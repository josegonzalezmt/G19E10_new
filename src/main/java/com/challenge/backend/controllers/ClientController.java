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

import com.challenge.backend.entities.Client;
import com.challenge.backend.services.ClientService;

@RestController
@RequestMapping(path = "api/Client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "save")
    public ResponseEntity<?> create(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @PostMapping(path = "all")
    public ResponseEntity<?> createAll(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(clientService.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> readById(@PathVariable int id) {
        return new ResponseEntity<>(clientService.readById(id), HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.CREATED);
    }

    @PutMapping(path = "all")
    public ResponseEntity<?> updateAll(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "all")
    public ResponseEntity<?> deleteAll() {
        return new ResponseEntity<>(clientService.deleteAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(clientService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
