package com.luv2code.crud.demo.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handler code here
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc) {

        // create student error response

        StudentErrorResponse error  = new StudentErrorResponse() ;
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return responseEntity

        return new ResponseEntity <> (error, HttpStatus.NOT_FOUND) ;

    }


    // add exceptionhandler to catchallexception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exc) {

        StudentErrorResponse error  = new StudentErrorResponse() ;
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return responseEntity

        return new ResponseEntity <> (error, HttpStatus.BAD_REQUEST) ;


    }


}
