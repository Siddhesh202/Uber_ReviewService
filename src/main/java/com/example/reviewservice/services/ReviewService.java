package com.example.reviewservice.services;

import com.example.reviewservice.models.Review;
import com.example.reviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************");
        Review r = Review
                .builder()
                .content("Amazing Ride Quality")
                .rating(5.0)
                .build(); // Code to create plain java object

        reviewRepository.save(r); // this code executes sql query
    }
}
