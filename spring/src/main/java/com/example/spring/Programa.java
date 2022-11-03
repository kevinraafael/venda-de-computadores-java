package com.example.spring;

import com.example.spring.entities.Pagamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {


    public static void main(String[] args) {
        Pagamento pag = new Pagamento(100.3,66.6,1,"descricao");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pag);
        em.getTransaction().commit();

        System.out.println("Pronto");
    }
}
