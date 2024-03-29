package com.employeedao.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    EntityManagerFactory man = Persistence.createEntityManagerFactory("re");
    EntityManager em ;

    public EmployeeDAOImpl() {
        em= man.createEntityManager();
    }

    @Override
    public void addEmployee(Employee employee) {

        em = man.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void updateEmployee(Employee employee) {

        em = man.createEntityManager();
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void deleteEmployee(Employee employee) {

        em = man.createEntityManager();
        em.getTransaction().begin();
        Employee managedEmployee = em.merge(employee);
        em.remove(managedEmployee);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Employee getEmployee(int id) {
     return em.find(Employee.class,id);

    }

    @Override
    public List<Employee> getAllEmployees() {

        return (List<Employee>) em.createNamedQuery("getAll").getResultList();
    }

    public boolean isEmailUnique(String email) {
        em = man.createEntityManager();
        String queryString = "SELECT COUNT(e) FROM Employee e WHERE e.mail = :email";
        Query query = em.createQuery(queryString);
        query.setParameter("email", email);
        Long count = (Long) query.getSingleResult();
        em.close();
        return count == 0;    }
}
