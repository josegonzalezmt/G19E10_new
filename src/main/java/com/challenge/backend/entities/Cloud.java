package com.challenge.backend.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Cloud {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(name = "`year`", nullable = false)
    private int year;

    @Column(nullable = false)
    private String description;

    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({ "clouds" })
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JsonIgnoreProperties({ "cloud", "client" })
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cloud")
    private List<Message> messages;

    @JsonIgnoreProperties({ "cloud", "messages" })
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cloud")
    private List<Reservation> reservations;

}
