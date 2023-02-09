package com.ssd.springboot.tasks.SpringBootAllTasks.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.springboot.tasks.SpringBootAllTasks.EmpService.EmployeeService;
import com.ssd.springboot.tasks.SpringBootAllTasks.Entity.Employee;
import com.ssd.springboot.tasks.SpringBootAllTasks.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

	@PostMapping("/save")
	public ResponseEntity<?> saveEmp(@Valid @RequestBody Employee emp, BindingResult reusult) {
		if (reusult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();
			reusult.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);

		}

		Employee saveEmp = empservice.saveEmp(emp);
		return new ResponseEntity<Employee>(saveEmp, HttpStatus.CREATED);

	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> findAllEmp() {
		List<Employee> allEmployess = empservice.findallEmployes();
		return new ResponseEntity<List<Employee>>(allEmployess, HttpStatus.OK);
	}

	@GetMapping("/find/email/{email}")
	public ResponseEntity<Employee> findEmpByEmail(@PathVariable String email) {
		Employee empByEmail = empservice.findEmpByEmail(email);
		return new ResponseEntity<Employee>(empByEmail, HttpStatus.OK);
	}

	@GetMapping("/find/name/{name}")
	public ResponseEntity<List<Employee>> findEmpByName(@PathVariable String name) {
		List<Employee> empByName = empservice.findEmpByName(name);
		return new ResponseEntity<List<Employee>>(empByName, HttpStatus.OK);
	}

	@GetMapping("/find/id/{id}")
	public ResponseEntity<Employee> findEmpById(@PathVariable Long id) throws EmployeeNotFoundException {
		Employee empById = empservice.findEmpById(id);
		return new ResponseEntity<Employee>(empById, HttpStatus.OK);

	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable Long id) {
		String responce = empservice.deleteById(id);
		return new ResponseEntity<String>(responce, HttpStatus.OK);

	}

	@DeleteMapping("/delete/email/{email}")
	public ResponseEntity<String> deleteEmpByEmail(@PathVariable String email) {
		String responce = empservice.deleteByEmail(email);
		return new ResponseEntity<String>(responce, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp) {
		Employee update = empservice.updateEmp(emp);
		return new ResponseEntity<Employee>(update, HttpStatus.OK);

	}
}
