package org.rustamosmanov.spring.springboot.service;

import jakarta.transaction.Transactional;
import org.rustamosmanov.spring.springboot.dao.EmployeeDAO;
import org.rustamosmanov.spring.springboot.entity.EmployeeBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<EmployeeBD> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }


    @Override
    @Transactional
    public void saveEmployee(EmployeeBD employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(EmployeeBD employee) {
        employeeDAO.deleteEmployee(employee);
    }

    @Override
    @Transactional
    public EmployeeBD getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

}
