package com.ironhack.stadiumhunterapi.repository;

import com.ironhack.stadiumhunterapi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM review  WHERE stadium_id = :stadiumId", nativeQuery = true)
    List<Review> findReviewsByStadiumId(@Param("stadiumId") Long stadiumId);

    @Query(value = "SELECT user_id FROM review GROUP BY user_id ORDER BY COUNT(*) DESC limit 5", nativeQuery = true)
    List<Long> findTopReviewersUsers();

    @Query(value = "SELECT AVG(RATING) FROM review WHERE stadium_id = :stadiumId", nativeQuery = true)
    Double findAvgRating(@Param("stadiumId") Long stadiumId);

}
