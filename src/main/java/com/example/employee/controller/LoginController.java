package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.model.User;
import com.example.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private final EmployeeRepository employeeRepository;
	
	public LoginController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@PostMapping
	public int login(@RequestBody User user) {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<Employee> employeeList = new ArrayList<>();
		employees.forEach(employeeList::add);
		Long count = employeeList.stream().filter(employee -> employee.getName().equals(user.getName()) && 
				employee.getPassword().equals(user.getPassword())).count();
		if (count > 0) {
			return 1;
		} else {
			throw new RuntimeException("Username or Password is wrong");
		}
	}

}
