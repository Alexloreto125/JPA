package org.example.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private EntityManager em;
    public LocationDAO(EntityManager em){
        this.em= em;

    }
    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(location);

            transaction.commit();


        } catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }


    public Location getById(Long id){
        return em.find(Location.class, id);
    }



    public void delete(Location location){

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.remove(location);

            transaction.commit();

        }catch (Exception e ){
            System.out.println(e.getMessage()+ e.getCause());

        }
    }
}
