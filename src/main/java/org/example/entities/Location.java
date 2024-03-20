package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private Persona nome;
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    public Location(Persona nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }
}
