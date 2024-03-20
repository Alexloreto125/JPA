package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Persona persona;


    private Stato stato;

    @OneToOne
    @JoinColumn(name = "event_id")
    private Evento evento;


    public Partecipazione(Evento evento, Stato stato){
        this.evento= evento;
        this.stato= stato;

    }

    public Stato getStato() {
        return stato;
    }
}
