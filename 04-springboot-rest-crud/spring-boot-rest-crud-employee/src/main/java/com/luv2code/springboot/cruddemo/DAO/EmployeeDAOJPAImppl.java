package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.employee;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImppl implements EmployeeDAO {

 private EntityManager entitymanager ;

  @Autowired
  public EmployeeDAOJPAImppl(EntityManager theEntityManager) {
      entitymanager = theEntityManager;
  }

    @Override
    public List<employee> findAll() {
      TypedQuery <employee> theQuery =  entitymanager.createQuery("from Employee", employee.class);
      List <employee> employees = theQuery.getResultList();


      return employees;

    }

    @Override
    public employee findById(int theId) {

        employee Employee = entitymanager.find(employee.class, theId) ;

        return  Employee;
    }

    @Override
    public employee Save(employee theEmployee) {
      employee dbEmployee = entitymanager.merge(theEmployee);

        return dbEmployee;
    }


    // since it will be handled in the service layer, @Transactional is not needed
    @Override
    public void DeleteById(int Id) {

      employee theEmployee = entitymanager.find(employee.class, Id);

      entitymanager.remove(theEmployee);



    }


}
