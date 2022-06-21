package com.ironhack.stadiumhunterapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private String comment;
    private int rating;
    private Long stadiumId;
}
