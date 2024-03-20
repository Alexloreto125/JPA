package org.example.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {

    private EntityManager em;
    public PersonaDAO(EntityManager em){
        this.em= em;

    }
    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(persona);

            transaction.commit();


        } catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }


    public Persona getById(Long id){
        return em.find(Persona.class, id);
    }



    public void delete(Persona persona){

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.remove(persona);

            transaction.commit();

        }catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }
}
