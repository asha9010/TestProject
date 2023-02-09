package com.ssd.springboot.tasks.SpringBootAllTasks.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ssd.springboot.tasks.SpringBootAllTasks.EmpRepository.EmployeeRepository;
import com.ssd.springboot.tasks.SpringBootAllTasks.Entity.Employee;
import com.ssd.springboot.tasks.SpringBootAllTasks.ServiceImpl.EmployeeServicesImpl;
import com.ssd.springboot.tasks.SpringBootAllTasks.exception.EmployeeNotFoundException;

@ExtendWith(MockitoExtension.class)
public class EmployeeServicesImplTesting {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServicesImpl employeeServicesImpl;

	private Employee employee;

	@BeforeEach
	public void setup() {

		employee = new Employee(2L, 23, "asha", "asha@gmail.com", "vskp");
	}

	@Test
	public void saveEmptest_1() {

		when(employeeRepository.save(employee)).thenReturn(employee);

		// when
		Employee emp = employeeServicesImpl.saveEmp(employee);
		// then
		assertThat(emp).isNotNull();
	}

	@Test
	public void saveEmptest_1_negtive() {

		when(employeeRepository.save(employee)).thenReturn(null);

		// when
		Employee emp = employeeServicesImpl.saveEmp(employee);
		// then
		assertThat(emp).isNull();
	}

	@Test
	public void findallEmployes_testing() {

		Employee employee1 = new Employee(10L, 22, "santhoshi", "santhoshi@gmail.com", "vskp");

		when(employeeRepository.findAll()).thenReturn(List.of(employee, employee1));

		List<Employee> empList = employeeServicesImpl.findallEmployes();

		assertThat(empList.size()).isEqualTo(2);

	}

	@Test
	public void findallEmployes_testing_negtive() {

		
		Employee employee1 = new Employee(10L, 22, "santhoshi", "santhoshi@gmail.com", "vskp");

		when(employeeRepository.findAll()).thenReturn(Collections.emptyList());

		List<Employee> empList = employeeServicesImpl.findallEmployes();

		assertThat(empList.size()).isEqualTo(0);
	
	}
	
	@Test
	public void  getEmployee_findEmpById(){
		Long empId=2L;
		when(employeeRepository.findById(empId)).thenReturn(Optional.of(employee));
		
		  Employee emp = employeeServicesImpl.findEmpById(empId);
		  
		  assertThat(emp.getName()).isEqualTo("asha");
			
	}
	
	/*
	 * @Test public void getEmployee_findEmpById_checkException() {
	 * 
	 * when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(
	 * employee));
	 * 
	 * assertThrows(EmployeeNotFoundException.class,()->employeeServicesImpl.
	 * findEmpById(6L));
	 * 
	 * verify(employeeRepository,never()).findById(anyLong());
	 * 
	 * 
	 * 
	 * }
	 */
	

}
