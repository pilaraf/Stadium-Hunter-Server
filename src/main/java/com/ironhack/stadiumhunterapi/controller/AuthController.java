package com.ironhack.stadiumhunterapi.controller;

import com.google.gson.Gson;
import com.ironhack.stadiumhunterapi.DTO.UserVerifyDTO;
import com.ironhack.stadiumhunterapi.model.User;
import com.ironhack.stadiumhunterapi.repository.UserRepository;
import com.ironhack.stadiumhunterapi.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public String verifyToken(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getName());
        Gson gson = new Gson();
        String userDetails = gson.toJson(userVerifyDTO);
        return userDetails;
    }
}
