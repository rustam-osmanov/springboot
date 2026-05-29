package org.rustamosmanov.spring.springboot.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.rustamosmanov.spring.springboot.entity.EmployeeBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<EmployeeBD> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        List<EmployeeBD> allEmployees = session.createQuery("from EmployeeBD", EmployeeBD.class)
                .getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(EmployeeBD employee) {
        Session session = entityManager.unwrap(Session.class);
        if (employee.getId() == null || employee.getId() == 0) {
            session.persist(employee);
        } else {
            session.merge(employee);
        }
    }

    @Override
    public void deleteEmployee(EmployeeBD employee) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(employee);
    }

    @Override
    public EmployeeBD getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        EmployeeBD employee = session.get(EmployeeBD.class, id);
        return employee;
    }

}
