package com.wct.jpa.main;

import com.wct.jpa.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wct");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1 = new Employee("张艺凡",1000);
        Employee employee2 = new Employee("张铁标",2000);
        employee1.setManager(employee2);
        em.persist(employee1);

        em.getTransaction().commit();
        em.close();
    }
}
