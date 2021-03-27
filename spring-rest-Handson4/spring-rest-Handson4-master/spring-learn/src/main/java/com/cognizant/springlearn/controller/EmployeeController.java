package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Start Controller updateEmployee() method");
		LOGGER.info("End Controller updateEmployee() method");
		return employeeService.updateEmployee(employee);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		LOGGER.info("Start Controller deleteEmployee() method");
		employeeService.deleteEmployee(id);
		LOGGER.info("End Controller deleteEmployee() method");
	}
	
	@GetMapping("/employees/{id}")
	public Employee getOneEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		LOGGER.info("Start Controller getOneEmployee() method");
		LOGGER.info("End Controller getOneEmployee() method");
		return employeeService.getOneEmployee(id);
	}
}
