package com.example.reviewservice.services;

import com.example.reviewservice.Utilities.ReviewInput;
import com.example.reviewservice.models.Review;
import com.example.reviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService{
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Long createReview(ReviewInput body) {
        Review r = Review
                .builder()
                .content(body.content)
                .rating(body.rating)
                .build();

        Review finalReview = reviewRepository.save(r);
        return finalReview.getId();
    }

}
