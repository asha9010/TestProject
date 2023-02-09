package com.ssd.springboot.tasks.SpringBootAllTasks.EmpRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.springboot.tasks.SpringBootAllTasks.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<List<Employee>> findByName(String name);

	Optional<Employee> findByEmail(String email);

	void deleteByEmail(String email);

}
