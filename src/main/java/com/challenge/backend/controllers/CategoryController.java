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

import com.challenge.backend.entities.Category;
import com.challenge.backend.services.CategoryService;

@RestController
@RequestMapping(path = "api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "save")
    public ResponseEntity<?> create(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @PostMapping(path = "all")
    public ResponseEntity<?> createAll(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(categoryService.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> readById(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.readById(id), HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(category), HttpStatus.CREATED);
    }

    @PutMapping(path = "all")
    public ResponseEntity<?> updateAll(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(category), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "all")
    public ResponseEntity<?> deleteAll() {
        return new ResponseEntity<>(categoryService.deleteAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}