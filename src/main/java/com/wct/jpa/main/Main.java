package com.wct.jpa.main;

import com.wct.jpa.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wct");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<User> users = em.createQuery("FROM User").getResultList();
        for(User user:users){
            System.out.println("user:"+user.getAccount());
        }

        em.getTransaction().commit();
        em.close();
    }
}
