package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.employee;

import java.util.List;

public interface EmployeeDAO{

    List<employee> findAll();

    employee findById(int theId);

    employee Save (employee theEmployee) ;

    void DeleteById (int Id) ;

}
