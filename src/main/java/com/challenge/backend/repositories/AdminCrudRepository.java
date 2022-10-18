package com.challenge.backend.repositories;


import com.challenge.backend.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {
}
