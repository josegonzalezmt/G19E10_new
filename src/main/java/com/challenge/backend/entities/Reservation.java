package com.challenge.backend.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date devolutionDate;

    @Column(nullable = false)
    private String status = "created";

    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({ "reservations" })
    @ManyToOne(fetch = FetchType.EAGER)
    private Cloud cloud;

    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({ "messages", "reservations" })
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @JoinColumn(nullable = true)
    @OneToOne(fetch = FetchType.EAGER)
    private Score score;

}
