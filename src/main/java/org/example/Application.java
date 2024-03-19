package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Evento;
import org.example.entities.EventoDAO;
import org.example.entities.TipoEvento;

import java.util.Date;

public class Application {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {

        EntityManager em= emf.createEntityManager();

      EventoDAO eventoDao= new EventoDAO(em);


      Evento nuovoEvento= new Evento("Riunione",new Date(),"Pianificazione dungeon bloodborne",TipoEvento.Privato,4);
      Evento nuovoEvento2= new Evento("Conferenza",new Date(),"Votazione per il CEO di For Honor",TipoEvento.Pubblico,10);
      Evento nuovoEvento3= new Evento("Estrazione",new Date(),"Estrazione Zombie",TipoEvento.Privato,6);
      Evento nuovoEvento4= new Evento("Secret",new Date(),"Disinnesco bombe",TipoEvento.Privato,5);

      eventoDao.save(nuovoEvento);
      eventoDao.save(nuovoEvento2);
      eventoDao.save(nuovoEvento3);
      eventoDao.save(nuovoEvento4);

      Long eventoId= nuovoEvento.getId();
      Evento eventoRecuperato= eventoDao.getById(eventoId);

        System.out.println("Evento recuperato "+ eventoRecuperato.getTitolo());


        Long eventoEl= nuovoEvento4.getId();
        Evento eventoDaEliminare= eventoDao.getById(eventoEl);

        eventoDao.delete(eventoDaEliminare);

        System.out.println("Evento Eliminato");


        em.close();
        emf.close();

        System.out.println("Hello World!");
    }





}
