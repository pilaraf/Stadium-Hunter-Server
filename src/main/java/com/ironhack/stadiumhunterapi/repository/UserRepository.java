package com.ironhack.stadiumhunterapi.repository;

import com.ironhack.stadiumhunterapi.model.Stadium;
import com.ironhack.stadiumhunterapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    /*@Query(value = "SELECT stadium.id,name,city, country,capacity, longitude, latitude FROM stadium INNER JOIN user_hunted_stadiums ON stadium.id = hunted_stadiums_id WHERE user_id = :userId", nativeQuery = true)
    List<Stadium> findStadiumsByUser(@Param("userId") Long userId);*/

  /*  @Query(value = "SELECT hunted_stadiums_id FROM user_hunted_stadiums WHERE user_id = :userId", nativeQuery = true)
    List<Long> findStadiumsIdByUser(@Param("userId") Long userId);*/

    @Query(value = "SELECT user_id FROM user_hunted_stadiums GROUP BY user_id ORDER BY COUNT(hunted_stadiums_id) DESC limit 5", nativeQuery = true)
    List<Long> findTopUsers();

    @Query(value = "SELECT country FROM stadium INNER JOIN user_hunted_stadiums ON stadium.id = hunted_stadiums_id WHERE user_id = :userId GROUP BY country",nativeQuery = true)
    List<String> countriesByUserId(@Param("userId") Long userId);
}
