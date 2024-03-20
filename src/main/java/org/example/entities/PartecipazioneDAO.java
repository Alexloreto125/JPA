package org.example.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private EntityManager em;
    public PartecipazioneDAO(EntityManager em){
        this.em= em;

    }
    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(partecipazione);

            transaction.commit();


        } catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }


    public Partecipazione getById(Long id){
        return em.find(Partecipazione.class, id);
    }



    public void delete(Partecipazione partecipazione){

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.remove(partecipazione);

            transaction.commit();

        }catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }
}
