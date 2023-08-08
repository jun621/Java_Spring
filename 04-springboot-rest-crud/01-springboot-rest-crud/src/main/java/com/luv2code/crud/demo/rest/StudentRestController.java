package com.luv2code.crud.demo.rest;


import com.luv2code.crud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    // define @PostConstruct to define the data

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Pooja", "Patel"));
        theStudents.add(new Student("Austin", " Malone"));
        theStudents.add(new Student("Kimura", "Masahiko"));
        theStudents.add(new Student("Yujiro","Hanma"));

    }


    // add endpoint for /student

    @GetMapping("/students")
    public List<Student> getStudents(){


        return theStudents;
    }

  // add endpoint "/students/{studentId}"

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId ){

      // check the studentId against the listSize
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new RuntimeException("StudentId not found" + studentId);
        }

      return theStudents.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
  

}
