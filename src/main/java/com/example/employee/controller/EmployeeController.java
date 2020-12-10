package com.example.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public int addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return 1;
	}
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeService.findAll();
	}
	
	@PutMapping("/{empId}")
	public int updateEmployee(@PathVariable Integer empId, @RequestBody Employee employee) {
		employeeService.update(empId, employee);
		return 1;
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmployee(@PathVariable Integer empId) {
		employeeService.delete(empId);
	}

}
