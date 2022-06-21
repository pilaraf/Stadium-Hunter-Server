package com.ironhack.stadiumhunterapi.service.impl;

import com.ironhack.stadiumhunterapi.DTO.ReviewDTO;
import com.ironhack.stadiumhunterapi.model.Review;
import com.ironhack.stadiumhunterapi.model.User;
import com.ironhack.stadiumhunterapi.repository.ReviewRepository;
import com.ironhack.stadiumhunterapi.repository.UserRepository;
import com.ironhack.stadiumhunterapi.service.interfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReviewService implements IReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private StadiumService stadiumService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    public List<Review> findByStadiumId(Long stadiumId){
        return reviewRepository.findReviewsByStadiumId(stadiumId);
    }

    public void saveReview(ReviewDTO reviewDTO){
        Review newReview = new Review();
        //getting the current user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            email = authentication.getName();
        }
        User currentUser = userRepository.findByEmail(email);

        newReview.setRating(reviewDTO.getRating());
        newReview.setComment(reviewDTO.getComment());
        newReview.setStadium(stadiumService.findById(reviewDTO.getStadiumId()));
        newReview.setUser(currentUser);
        reviewRepository.save(newReview);
    }

    public List<User> getTopReviewersUsers(){
        List<Long> users = reviewRepository.findTopReviewersUsers();
        List<User> topUsers = new ArrayList<>();
        for(Long id : users){
            topUsers.add(userRepository.findById(id).orElse(null));
        }
        return topUsers;
    }

    public Double avgStadiumRating(Long stadiumId) {
        Double rating = Double.valueOf(0);
        Double ratingFromDB = reviewRepository.findAvgRating(stadiumId);
        if (ratingFromDB != null){
            rating = ratingFromDB;
        }
        return rating;
    }
}
