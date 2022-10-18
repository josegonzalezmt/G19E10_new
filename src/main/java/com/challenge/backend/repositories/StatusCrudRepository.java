package com.challenge.backend.repositories;

import com.challenge.backend.entities.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusCrudRepository extends CrudRepository<Status, Integer> {
}
