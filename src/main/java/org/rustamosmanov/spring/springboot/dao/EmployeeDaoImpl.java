package org.rustamosmanov.spring.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        /*
        Session session = entityManager.unwrap(Session.class);
        List<EmployeeBD> allEmployees = session.createQuery("from EmployeeBD", EmployeeBD.class)
                .getResultList();
        */
        Query query = entityManager.createQuery("from EmployeeBD");
        List<EmployeeBD> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(EmployeeBD employee) {
        if (employee.getId() == null || employee.getId() == 0) {
            entityManager.persist(employee);
        } else {
            entityManager.merge(employee);
        }
    }

    @Override
    public void deleteEmployee(EmployeeBD employee) {
        entityManager.remove(employee);
    }

    @Override
    public EmployeeBD getEmployee(int id) {
        EmployeeBD employee = entityManager.find(EmployeeBD.class, id);
        return employee;
    }

}
