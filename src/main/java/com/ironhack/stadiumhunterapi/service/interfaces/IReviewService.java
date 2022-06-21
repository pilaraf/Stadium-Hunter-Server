package com.ironhack.stadiumhunterapi.service.interfaces;

import com.ironhack.stadiumhunterapi.DTO.ReviewDTO;

public interface IReviewService {
    Object findByStadiumId(Long id);
    void saveReview(ReviewDTO reviewDTO);
}
