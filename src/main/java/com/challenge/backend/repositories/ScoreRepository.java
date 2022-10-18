package com.challenge.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.backend.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
