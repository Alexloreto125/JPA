package org.example.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private EntityManager em;


    public EventoDAO(EntityManager em){
        this.em= em;

    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(evento);

            transaction.commit();


        } catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }


    public Evento getById(Long id){
        return em.find(Evento.class, id);
    }



    public void delete(Evento evento){

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.remove(evento);

            transaction.commit();

        }catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }
}
