package com.example.vendadecomputadoresjdk11.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> entidade;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("postgres");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Dao(Class<E> entidade) {
        this.entidade = entidade;
        em = emf.createEntityManager();
    }
    public Dao(){

    }
}