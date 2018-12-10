package com.wct.jpa.main;

import com.wct.jpa.entity.Employee;
import com.wct.jpa.enumeration.EmployeeType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("wct");
    }


    public static void main(String[] args) {
//        testNamedQuery();
//        testEnum();
    }


    /**
     * 测试命名查询
     */
    private static void testNamedQuery(){
        EntityManager em = emf.createEntityManager();
        List<Employee> employees = em.createNamedQuery("Employee.findAll",Employee.class).getResultList();
        for (Employee employee:employees){
            System.out.println(employee.getId());
        }
        Employee employee = em.createNamedQuery("Employee.findById",Employee.class)
                .setParameter("id",2)
                .getSingleResult();
        System.out.println(employee.getName());
        em.close();
    }

    /**
     * 测试枚举
     */
    private static void testEnum(){
        EntityManager em = emf.createEntityManager();
//        存一个对象
//        em.getTransaction().begin();
//        Employee employee = new Employee("赵信",20000);
//        employee.setEmployeeType(EmployeeType.CONTRACT_EMPLOYEE);
//        em.persist(employee);
//        em.getTransaction().commit();

//        查询含有枚举类型的对象
//        Employee get = em.find(Employee.class,22);
//        System.out.println(get.getEmployeeType());

        em.close();
    }

    /**
     * 测试Criteria API查询
     */
    private static void testCriteria(){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
    }
}
