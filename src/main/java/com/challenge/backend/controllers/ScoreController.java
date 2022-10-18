package com.challenge.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.backend.entities.Score;
import com.challenge.backend.services.ScoreService;

@RestController
@RequestMapping(path = "api/Score")
@CrossOrigin(origins = "*")
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;

    @PostMapping(path = "save")
    public ResponseEntity<?> create(@RequestBody Score score) {
        return new ResponseEntity<>(scoreService.create(score), HttpStatus.CREATED);
    }

    @PostMapping(path = "all")
    public ResponseEntity<?> createAll(@RequestBody Score score) {
        return new ResponseEntity<>(scoreService.create(score), HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(scoreService.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> readById(@PathVariable int id) {
        return new ResponseEntity<>(scoreService.readById(id), HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@RequestBody Score score) {
        return new ResponseEntity<>(scoreService.update(score), HttpStatus.CREATED);
    }

    @PutMapping(path = "all")
    public ResponseEntity<?> updateAll(@RequestBody Score score) {
        return new ResponseEntity<>(scoreService.update(score), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "all")
    public ResponseEntity<?> deleteAll() {
        return new ResponseEntity<>(scoreService.deleteAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(scoreService.deleteById(id), HttpStatus.NO_CONTENT);
    }
    
}