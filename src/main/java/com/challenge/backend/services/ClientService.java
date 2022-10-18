package com.challenge.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.backend.entities.Client;
import com.challenge.backend.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) {
        if (clientRepository.existsById(client.getIdClient()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client already exists");
        return clientRepository.save(client);
    }

    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    public Client readById(int id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client does not exists"));
    }

    public Client update(Client client) {
        Client previous = readById(client.getIdClient());
        clientRepository.save(client);
        return previous;
    }

    public List<Client> deleteAll() {
        clientRepository.deleteAll();
        return readAll();
    }

    public Client deleteById(int id) {
        Client client = readById(id);
        clientRepository.delete(client);
        return client;
    }

}