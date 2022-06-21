package com.ironhack.stadiumhunterapi.repository;

import com.ironhack.stadiumhunterapi.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    /*@Query(value = "SELECT * FROM stadium WHERE name = :stadiumName AND city = :stadiumCity", nativeQuery = true)
    Optional<Stadium> findByNameAndCity(@Param("stadiumName") String stadiumName, @Param("stadiumCity") String stadiumCity );*/

    boolean existsStadiumByNameAndCity(String name, String city);
}
