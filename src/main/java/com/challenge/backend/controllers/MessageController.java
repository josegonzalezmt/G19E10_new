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

import com.challenge.backend.entities.Message;
import com.challenge.backend.services.MessageService;

@RestController
@RequestMapping(path = "api/Message")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(path = "save")
    public ResponseEntity<?> create(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.create(message), HttpStatus.CREATED);
    }

    @PostMapping(path = "all")
    public ResponseEntity<?> createAll(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.create(message), HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(messageService.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> readById(@PathVariable int id) {
        return new ResponseEntity<>(messageService.readById(id), HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.update(message), HttpStatus.CREATED);
    }

    @PutMapping(path = "all")
    public ResponseEntity<?> updateAll(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.update(message), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "all")
    public ResponseEntity<?> deleteAll() {
        return new ResponseEntity<>(messageService.deleteAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(messageService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}