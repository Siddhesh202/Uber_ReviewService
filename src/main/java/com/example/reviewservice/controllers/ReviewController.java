package com.example.reviewservice.controllers;

import com.example.reviewservice.adapters.CreateReviewDtoToReviewAdapterImpl;
import com.example.reviewservice.dtos.CreateReviewDto;
import com.example.reviewservice.dtos.ReviewDto;
import com.example.reviewservice.models.Review;
import com.example.reviewservice.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final CreateReviewDtoToReviewAdapterImpl createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapterImpl createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @PostMapping()
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto request) {
        Review incomingReview  = this.createReviewDtoToReviewAdapter.convertDto(request);
        if(incomingReview == null) {
            return new ResponseEntity<>("Invalid arguments", HttpStatus.BAD_REQUEST);
        }
        Review review = this.reviewService.publishReview(incomingReview);

        ReviewDto response = ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable Long reviewId) {
        try {
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId) {
        try {
            boolean isDeleted = this.reviewService.deleteReviewById(reviewId);
            if(!isDeleted) return new ResponseEntity<>("Unable to delete Review", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody Review request){
        try {
            Review review = this.reviewService.updateReview(reviewId, request);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
