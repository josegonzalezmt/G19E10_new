package com.challenge.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.backend.entities.Score;
import com.challenge.backend.repositories.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score create(Score score) {
        if (scoreRepository.existsById(score.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Score already exists");
        return scoreRepository.save(score);
    }

    public List<Score> readAll() {
        return scoreRepository.findAll();
    }

    public Score readById(int id) {
        return scoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Score does not exists"));
    }

    public Score update(Score score) {
        Score previous = readById(score.getId());
        scoreRepository.save(score);
        return previous;
    }

    public List<Score> deleteAll() {
        scoreRepository.deleteAll();
        return readAll();
    }

    public Score deleteById(int id) {
        Score score = readById(id);
        scoreRepository.delete(score);
        return score;
    }
    
}
