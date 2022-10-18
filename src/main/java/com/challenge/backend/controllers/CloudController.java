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

import com.challenge.backend.entities.Cloud;
import com.challenge.backend.services.CloudService;

@RestController
@RequestMapping(path = "api/Cloud")
@CrossOrigin(origins = "*")
public class CloudController {
    @Autowired
    private CloudService cloudService;

    @PostMapping(path = "save")
    public ResponseEntity<?> create(@RequestBody Cloud cloud) {
        return new ResponseEntity<>(cloudService.create(cloud), HttpStatus.CREATED);
    }

    @PostMapping(path = "all")
    public ResponseEntity<?> createAll(@RequestBody Cloud cloud) {
        return new ResponseEntity<>(cloudService.create(cloud), HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(cloudService.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> readById(@PathVariable int id) {
        return new ResponseEntity<>(cloudService.readById(id), HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@RequestBody Cloud cloud) {
        return new ResponseEntity<>(cloudService.update(cloud), HttpStatus.CREATED);
    }

    @PutMapping(path = "all")
    public ResponseEntity<?> updateAll(@RequestBody Cloud cloud) {
        return new ResponseEntity<>(cloudService.update(cloud), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "all")
    public ResponseEntity<?> deleteAll() {
        return new ResponseEntity<>(cloudService.deleteAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(cloudService.deleteById(id), HttpStatus.NO_CONTENT);
    }
    
}