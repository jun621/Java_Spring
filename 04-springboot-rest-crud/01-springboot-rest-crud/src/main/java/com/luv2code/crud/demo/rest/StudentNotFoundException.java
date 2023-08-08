package com.luv2code.crud.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StudentNotFoundException extends RuntimeException {

      public StudentNotFoundException(String message) {

          super(message);
      }

      public StudentNotFoundException(String message, Throwable cause) {
          super (message, cause) ;
      }

       public StudentNotFoundException(Throwable cause) {
          super(cause) ;
       }


}
