package com.challenge.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStatus;
    private String status;

    @ManyToOne
    @JoinColumn(name="idReservation")
    @JsonIgnoreProperties({"reservations","status"})
    private Reservation reservations;

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservation) {
        this.reservations = reservation;
    }
}
