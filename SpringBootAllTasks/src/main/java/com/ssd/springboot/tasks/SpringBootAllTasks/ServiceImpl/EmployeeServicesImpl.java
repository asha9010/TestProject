package com.ssd.springboot.tasks.SpringBootAllTasks.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.springboot.tasks.SpringBootAllTasks.EmpRepository.EmployeeRepository;
import com.ssd.springboot.tasks.SpringBootAllTasks.EmpService.EmployeeService;
import com.ssd.springboot.tasks.SpringBootAllTasks.Entity.Employee;
import com.ssd.springboot.tasks.SpringBootAllTasks.exception.EmployeeNotFoundException;

@Service
public class EmployeeServicesImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public Employee saveEmp(Employee emp) {

		Optional<Employee> employee = emprepo.findByEmail(emp.getEmail());
		if (!employee.isPresent()) {
			return emprepo.save(emp);
		}
		return null;
	}

	@Override
	public List<Employee> findallEmployes() {
		List<Employee> allEmployess = emprepo.findAll();

		return allEmployess;
	}

	@Override
	public Employee findEmpById(Long Id) throws EmployeeNotFoundException {
		Optional<Employee> findempbyid = emprepo.findById(Id);

		if (findempbyid.isPresent()) {

			return findempbyid.get();
		} else {
			throw new EmployeeNotFoundException("Employee Record not found with this Id :" + Id);
		}
	}

	@Override
	public List<Employee> findEmpByName(String name) {
		Optional<List<Employee>> findbyname = emprepo.findByName(name);

		if (findbyname.isPresent()) {
			return findbyname.get();
		} else {
			throw new EmployeeNotFoundException("Employee Record not found with this name :" + name);
		}
	}

	@Override
	public Employee findEmpByEmail(String email) {
		Optional<Employee> findbyemail = emprepo.findByEmail(email);

		if (findbyemail.isPresent()) {
			return findbyemail.get();
		} else {
			throw new EmployeeNotFoundException("Employee Record not found with this Email :" + email);

		}
	}

	@Override
	public String deleteById(Long id) {
		emprepo.deleteById(id);
		Optional<Employee> deletebyid = emprepo.findById(id);
		if (!deletebyid.isPresent()) {

			return "SucessfullyDeletedBy Id :" + id;

		}
		return null;
	}

	@Override
	public String deleteByEmail(String email) {
		emprepo.deleteByEmail(email);
		Optional<Employee> deletebyemail = emprepo.findByEmail(email);
		if (!deletebyemail.isPresent()) {

			return "SucessfullyDeletedByemail:" + email;

		}
		return null;
	}

	@Override
	public Employee updateEmp(Employee emp) {
		Employee saveemp = emprepo.save(emp);
		return saveemp;
	}

}
