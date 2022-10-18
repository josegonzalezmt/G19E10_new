package com.challenge.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.backend.entities.Category;
import com.challenge.backend.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        if (categoryRepository.existsById(category.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists");
        return categoryRepository.save(category);
    }

    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    public Category readById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category does not exists"));
    }

    public Category update(Category category) {
        Category previous = readById(category.getId());
        categoryRepository.save(category);
        return previous;
    }

    public List<Category> deleteAll() {
        categoryRepository.deleteAll();
        return readAll();
    }

    public Category deleteById(int id) {
        Category category = readById(id);
        categoryRepository.delete(category);
        return category;
    }

}