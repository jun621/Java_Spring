package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.employee;

import java.util.List;

public interface EmployeeService {

    List<employee> findAll();

    employee findById(int theId);

    employee Save (employee theEmployee) ;

    void DeleteById (int Id) ;


}
