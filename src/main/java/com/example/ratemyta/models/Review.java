package com.example.ratemyta.models;

import java.time.Instant;

public class Review {
    private int rating; // 1-5
    private String comment;
    private Instant timestamp;

    public Review() {
        this.timestamp = Instant.now();
    }

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
        this.timestamp = Instant.now();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}

