package com.example.reviewservice.services;

import com.example.reviewservice.models.Booking;
import com.example.reviewservice.models.Review;
import com.example.reviewservice.repositories.BookingRepository;
import com.example.reviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************");
//        Review r = Review
//                .builder()
//                .content("Amazing Ride Quality")
//                .rating(5.0)
//                .build(); // Code to create plain java object
//
//        Booking b = Booking
//                .builder()
//                .review(r)
//                .endTime(new Date())
//                .build();
//
//        // reviewRepository.save(r); // this code executes sql query
//        bookingRepository.save(b);
        
    }
}
