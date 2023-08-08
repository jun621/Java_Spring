package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // constructer injection

    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService) {

        employeeService = theemployeeService;
    }

    @GetMapping("/employees")
    public List<employee> findAll() {
        return employeeService.findAll();

    }

    // add mapping for GET /employees/{employeeID}
    @GetMapping("/employee/{employeeId}")
    public employee getEmployee(@PathVariable int employeeId) {

        employee Employee = employeeService.findById(employeeId);

        if (Employee == null) {

            throw new RuntimeException("the employee was not found" + employeeId);

        }

        return Employee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")

    public employee addEmployee(@RequestBody employee theEmployee) {

        theEmployee.setId(0);

        employee Employee = employeeService.Save(theEmployee);

        if (Employee == null) {
            throw new RuntimeException("Employee can not created" + theEmployee);
        }
        return Employee;

    }

    // add mapping for PUT /employees

    @PutMapping("/employees")

    public employee updateEmployee(employee theEmployee) {
        employee Employee = employeeService.Save(theEmployee);
        if (Employee == null) {
            throw new RuntimeException("can not update employee " + theEmployee);

        }
        return Employee;

    }

    // add delete mapping /employees
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeID) {

        employee theEmployee = employeeService.findById((employeeID));

        if (theEmployee == null) {

            throw new RuntimeException("the employee ID is null" + employeeID);

        }

          employeeService.DeleteById(employeeID);

        return  "deleted ID" + employeeID;
    }

}