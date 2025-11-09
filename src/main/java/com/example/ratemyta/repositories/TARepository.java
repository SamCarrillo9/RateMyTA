package com.example.ratemyta.repositories;

import com.example.ratemyta.models.TA;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TARepository extends MongoRepository<TA, String> {
    List<TA> findByNameContainingIgnoreCase(String name);
}
