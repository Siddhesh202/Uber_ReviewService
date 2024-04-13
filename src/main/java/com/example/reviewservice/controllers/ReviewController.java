package com.example.reviewservice.controllers;

import com.example.reviewservice.Utilities.ReviewInput;
import com.example.reviewservice.services.ReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/review")
    public Long postReview(@RequestBody ReviewInput input) {
        Long id = reviewService.createReview(input);
        return id;
    }
}
