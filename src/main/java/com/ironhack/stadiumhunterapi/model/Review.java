package com.ironhack.stadiumhunterapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="stadium_id")
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String comment;
    private int rating;
}
