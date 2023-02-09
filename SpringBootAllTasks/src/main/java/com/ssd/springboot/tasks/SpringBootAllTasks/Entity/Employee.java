package com.ssd.springboot.tasks.SpringBootAllTasks.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="emp_tb")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   
	private Long id;
   @Min(value = 18)
   @Max(value = 120)
   @Column(name="emp_age")
	private int age;
   @NotBlank(message = "Enter Valid Name")
   @Column(name="emp_name")
	private String name;
   @Email
   @NotBlank(message = " Enter Valid Email")
   @Column(name="emp_email")
	private String email;
   @NotBlank(message = " Enter Valid Address")
   @Column(name="emp_address")
	private String address;
	
	
	
	
	
}
