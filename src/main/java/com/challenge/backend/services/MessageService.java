package com.challenge.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.backend.entities.Message;
import com.challenge.backend.repositories.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message create(Message message) {
        if (messageRepository.existsById(message.getIdMessage()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Message already exists");
        return messageRepository.save(message);
    }

    public List<Message> readAll() {
        return messageRepository.findAll();
    }

    public Message readById(int id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message does not exists"));
    }

    public Message update(Message message) {
        Message previous = readById(message.getIdMessage());
        messageRepository.save(message);
        return previous;
    }

    public List<Message> deleteAll() {
        messageRepository.deleteAll();
        return readAll();
    }

    public Message deleteById(int id) {
        Message message = readById(id);
        messageRepository.delete(message);
        return message;
    }

}