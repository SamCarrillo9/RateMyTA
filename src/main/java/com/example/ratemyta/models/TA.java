package com.example.ratemyta.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "tas")
public class TA {
    @Id
    private String id;
    private String name;
    private List<Course> courses = new ArrayList<>();
    private double averageRating = 0.0;
    private List<Review> reviews = new ArrayList<>();

    public TA() {}

    public TA(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses != null ? courses : new ArrayList<>();
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews != null ? reviews : new ArrayList<>();
        recalculateAverage();
    }

    public void addReview(Review review) {
        if (review == null) return;
        if (this.reviews == null) this.reviews = new ArrayList<>();
        this.reviews.add(review);
        recalculateAverage();
    }

    private void recalculateAverage() {
        if (this.reviews == null || this.reviews.isEmpty()) {
            this.averageRating = 0.0;
            return;
        }
        double sum = 0.0;
        for (Review r : this.reviews) {
            sum += r.getRating();
        }
        this.averageRating = sum / this.reviews.size();
    }
}

