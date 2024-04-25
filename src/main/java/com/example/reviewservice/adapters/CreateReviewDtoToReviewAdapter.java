package com.example.reviewservice.adapters;

import com.example.reviewservice.dtos.CreateReviewDto;
import com.example.reviewservice.models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);
}
