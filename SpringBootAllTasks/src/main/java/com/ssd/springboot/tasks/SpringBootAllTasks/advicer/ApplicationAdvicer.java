package com.ssd.springboot.tasks.SpringBootAllTasks.advicer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssd.springboot.tasks.SpringBootAllTasks.exception.EmployeeNotFoundException;


@RestControllerAdvice
public class ApplicationAdvicer {

	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmployeeNotFoundException.class)
    public Map<String,String> handleRecordNotFoundException(EmployeeNotFoundException exmsg){
	  
	  Map<String,String> errorMsg=new HashMap<String,String>();
	  
	  errorMsg.put("errormsg",exmsg.getMessage());
	  
	  return errorMsg;
	  
	  
  }
  }
	
	
	
	
	
	

