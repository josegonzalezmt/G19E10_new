package com.challenge.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.backend.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
