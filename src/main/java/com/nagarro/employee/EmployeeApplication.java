package com.nagarro.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.employee.Employee;

@SpringBootApplication
@RestController
public class EmployeeApplication {
	
	@Autowired
	private EmployeeRepos employeeRepo;
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeRepo.save(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		
		return employeeRepo.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
