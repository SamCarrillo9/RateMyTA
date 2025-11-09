package com.example.ratemyta.controllers;

import com.example.ratemyta.models.Review;
import com.example.ratemyta.models.TA;
import com.example.ratemyta.repositories.TARepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tas")
public class TAController {

    private final TARepository repo;

    public TAController(TARepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<TA> list(@RequestParam(value = "q", required = false) String q) {
        if (q == null || q.isBlank()) {
            List<TA> out = new ArrayList<>();
            repo.findAll().forEach(out::add);
            return out;
        }
        return repo.findByNameContainingIgnoreCase(q);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TA> get(@PathVariable String id) {
        Optional<TA> t = repo.findById(id);
        return t.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TA> create(@RequestBody TA ta) {
        TA saved = repo.save(ta);
        return ResponseEntity.created(URI.create("/api/tas/" + saved.getId())).body(saved);
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<?> addReview(@PathVariable String id, @RequestBody Review review) {
        Optional<TA> t = repo.findById(id);
        if (t.isEmpty()) return ResponseEntity.notFound().build();
        TA ta = t.get();
        if (review.getRating() < 1 || review.getRating() > 5) {
            return ResponseEntity.badRequest().body("rating must be between 1 and 5");
        }
        ta.addReview(review);
        repo.save(ta);
        return ResponseEntity.ok(ta);
    }
}
