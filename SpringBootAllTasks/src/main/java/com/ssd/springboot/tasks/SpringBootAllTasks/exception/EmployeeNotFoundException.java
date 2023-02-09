package com.ssd.springboot.tasks.SpringBootAllTasks.exception;

public class EmployeeNotFoundException extends RuntimeException{	
	public EmployeeNotFoundException(String exmMsg) {
		super(exmMsg);
		
	}

}
