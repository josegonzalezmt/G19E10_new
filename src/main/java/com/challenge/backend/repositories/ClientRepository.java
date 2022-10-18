package com.challenge.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.backend.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
