package com.ironhack.stadiumhunterapi.controller;

import com.ironhack.stadiumhunterapi.model.Stadium;
import com.ironhack.stadiumhunterapi.model.User;
import com.ironhack.stadiumhunterapi.repository.StadiumRepository;
import com.ironhack.stadiumhunterapi.service.impl.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StadiumController {

    @Autowired
    private StadiumRepository stadiumRepository;

    @Autowired
    private StadiumService stadiumService;

    @PostMapping("/stadiums")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStadium(@RequestBody @Valid Stadium stadium) {
         stadiumService.saveStadium(stadium);
    }

    @GetMapping("/stadiums/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stadium getStadiumById(@PathVariable(name = "id") Long stadiumId) {
        return stadiumService.findById(stadiumId);
    }

    @GetMapping("/stadiums")
    @ResponseStatus(HttpStatus.OK)
    public List<Stadium> getStadiums() {
        return stadiumRepository.findAll();
    }


}
