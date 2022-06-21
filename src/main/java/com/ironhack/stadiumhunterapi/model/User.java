package com.ironhack.stadiumhunterapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please, you must provide a name.")
    private String name;
    @Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
            + "(?:[A-Za-z0-9-]*[A-Za-z0-9])?",
            message = "Provide a valid email address.")
    private String email;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}",
            message = "Password must have at least 6 characters and contain at least one number, one lowercase and one uppercase letter.")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @ManyToMany
    private List<Stadium> huntedStadiums;

    @ManyToMany
    private List<Stadium> remainingStadiums;

    //In order to do the signUp:
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
