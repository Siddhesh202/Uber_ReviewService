package com.example.reviewservice.services;

import com.example.reviewservice.models.Review;
import com.example.reviewservice.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService  {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        Optional<Review> review;
        try{
            review = reviewRepository.findById(id);
            if(review.isEmpty()) {
                throw new EntityNotFoundException("Review with id " + id + " not found");
            }
        }catch (Exception e) {
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id " + id + " not found", id);
            }
            throw new FetchNotFoundException("Unable to fetch, PLease try again later!", id);
        }
        return review;
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try{
            Review review = reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            reviewRepository.delete(review);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public Review publishReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review newReviewData) {
        Review review = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(newReviewData.getRating() != null){
            review.setRating(newReviewData.getRating());
        }
        if(newReviewData.getContent() != null){
            review.setContent(newReviewData.getContent());
        }
        return this.reviewRepository.save(review);
    }
}
