package com.ironhack.stadiumhunterapi.controller;

import com.ironhack.stadiumhunterapi.DTO.ReviewDTO;
import com.ironhack.stadiumhunterapi.model.Review;
import com.ironhack.stadiumhunterapi.model.Stadium;
import com.ironhack.stadiumhunterapi.model.User;
import com.ironhack.stadiumhunterapi.repository.ReviewRepository;
import com.ironhack.stadiumhunterapi.repository.StadiumRepository;
import com.ironhack.stadiumhunterapi.service.impl.ReviewService;
import com.ironhack.stadiumhunterapi.service.impl.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getReviewByStadiumId(@PathVariable(name = "id") Long stadiumId) {
        return reviewService.findByStadiumId(stadiumId);
    }

    @PostMapping("/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReview(@RequestBody @Valid ReviewDTO reviewDTO) {
            reviewService.saveReview(reviewDTO);
    }

    @GetMapping("/review/count")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getTopReviewersUsers(){
        return reviewService.getTopReviewersUsers();
    }

    @GetMapping("/review/avg/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Double avgStadiumRating(@PathVariable(name = "id") Long stadiumId) {
        return reviewService.avgStadiumRating(stadiumId);
    }

}
