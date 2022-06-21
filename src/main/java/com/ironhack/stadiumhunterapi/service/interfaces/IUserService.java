package com.ironhack.stadiumhunterapi.service.interfaces;

import com.ironhack.stadiumhunterapi.model.Stadium;
import com.ironhack.stadiumhunterapi.model.User;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IUserService {
    User saveUser(User userSignupDTO);
    List<User> getUsers();
    User findById(Long id);
    void addStadiumToUser(Long stadiumId, Authentication authentication);
    void removeStadium(Long stadiumId);
    List<Stadium> getUserStadiums();
}
