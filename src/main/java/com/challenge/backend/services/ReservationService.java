package com.challenge.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.challenge.backend.entities.Reservation;
import com.challenge.backend.repositories.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation create(Reservation reservation) {
        if (reservationRepository.existsById(reservation.getIdReservation()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Reservation already exists");
        return reservationRepository.save(reservation);
    }

    public List<Reservation> readAll() {
        return reservationRepository.findAll();
    }

    public Reservation readById(int id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exists"));
    }

    public Reservation update(Reservation reservation) {
        Reservation previous = readById(reservation.getIdReservation());
        reservationRepository.save(reservation);
        return previous;
    }

    public List<Reservation> deleteAll() {
        reservationRepository.deleteAll();
        return readAll();
    }

    public Reservation deleteById(int id) {
        Reservation reservation = readById(id);
        reservationRepository.delete(reservation);
        return reservation;
    }

}