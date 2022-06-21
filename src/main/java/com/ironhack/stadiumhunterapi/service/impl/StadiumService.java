package com.ironhack.stadiumhunterapi.service.impl;

import com.ironhack.stadiumhunterapi.model.Stadium;
import com.ironhack.stadiumhunterapi.repository.StadiumRepository;
import com.ironhack.stadiumhunterapi.service.interfaces.IStadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StadiumService implements IStadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    public Stadium findById(Long id){
        return stadiumRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stadium not found"));
    }

    public void saveStadium(Stadium stadium){
        //check if stadium already exists by name and city
        boolean exists = stadiumRepository.existsStadiumByNameAndCity(stadium.getName(), stadium.getCity());
        if(exists == false){
            stadiumRepository.save(stadium);
        }
    }
}
