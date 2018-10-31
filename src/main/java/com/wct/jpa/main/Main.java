package com.wct.jpa.main;

import com.wct.jpa.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wct");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class,2);
        user.setAccount("hahahaha");

        em.getTransaction().commit();
        em.close();
    }
}
