package com.example.employee.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	private EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RuntimeException("There is no employee with id: " + id);
		}
	}

	@Override
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee save(Employee entity) {
		if (validate(entity)) {			
			return employeeRepository.save(entity);
		} else {
			throw new RuntimeException("Required Field is not present.");
		}
	}

	@Override
	public void update(Integer id, Employee entity) {
		if (!validate(entity)) {
			throw new RuntimeException("Required Field is not present.");
		}
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			employee.setName(entity.getName());
			employee.setPassword(entity.getPassword());
			employee.setDob(entity.getDob());
			employee.setStateId(entity.getStateId());
			employee.setDistrictId(entity.getDistrictId());
			employeeRepository.save(employee);
		} else {
			throw new RuntimeException("There is no employee with id: " + id);
		}
	}
	
	private boolean validate(Employee entity) {
		if (entity.getName() == null || entity.getPassword() == null || entity.getDob() == null
				|| entity.getStateId() == null || entity.getDistrictId() == null) {
			return false;
		}
		return true;
	}
}
