package com.banfico.EcomApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class ExceptionAdvisor {
    @ExceptionHandler(DataNotValidException.class)
    public ResponseEntity<Object> handleDataNotValid(DataNotValidException e,
                                                     WebRequest request){
        Map<String ,Object> load=new LinkedHashMap<>();
        load.put("code", HttpStatus.NOT_ACCEPTABLE);
        load.put("message","Constraints Violated,Passed Invalid Data");
        load.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(load,HttpStatus.BAD_REQUEST);
    }

}
