package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {


        employeeDAO = theEmployeeDAO;
    }


    @Override
    public List<employee> findAll() {
        return employeeDAO.findAll();
    }


    @Override
    public employee findById(int theId) {
        return employeeDAO.findById(theId);
    }


    // making changes on the database
    @Transactional
    @Override
    public employee Save(employee theEmployee) {
        return employeeDAO.Save(theEmployee);
    }


    // making changes on the database
    @Transactional
    @Override
    public void DeleteById(int Id) {
        employeeDAO.DeleteById(Id);
    }


}
