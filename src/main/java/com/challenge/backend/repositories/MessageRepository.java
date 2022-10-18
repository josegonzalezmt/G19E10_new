package com.challenge.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.backend.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
