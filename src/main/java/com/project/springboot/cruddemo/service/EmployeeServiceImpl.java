package com.project.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.cruddemo.dao.EmployeeRepository;
import com.project.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeerepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		
		employeerepository = theEmployeeRepository;
	}
	
	
	@Override
	public List<Employee> findAll() {		
		
		return employeerepository.findAll();
	}

	
	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeerepository.findById(theId);

		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("DID not found employee Id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	
	public void save(Employee theEmployee) {
		
		employeerepository.save(theEmployee);

	}

	
	@Override
	public void deleteById(int theId) {

		employeerepository.deleteById(theId);
	}

}
