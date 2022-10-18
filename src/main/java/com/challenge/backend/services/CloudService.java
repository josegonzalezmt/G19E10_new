package com.challenge.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.backend.entities.Cloud;
import com.challenge.backend.repositories.CloudRepository;

@Service
public class CloudService {

    @Autowired
    private CloudRepository cloudRepository;

    public Cloud create(Cloud cloud) {
        if (cloudRepository.existsById(cloud.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cloud already exists");
        return cloudRepository.save(cloud);
    }

    public List<Cloud> readAll() {
        return cloudRepository.findAll();
    }

    public Cloud readById(int id) {
        return cloudRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cloud does not exists"));
    }

    public Cloud update(Cloud cloud) {
        Cloud previous = readById(cloud.getId());
        if (cloud.getCategory() == null)
            cloud.setCategory(previous.getCategory());
        cloudRepository.save(cloud);
        return previous;
    }

    public List<Cloud> deleteAll() {
        cloudRepository.deleteAll();
        return readAll();
    }

    public Cloud deleteById(int id) {
        Cloud cloud = readById(id);
        cloudRepository.delete(cloud);
        return cloud;
    }

}