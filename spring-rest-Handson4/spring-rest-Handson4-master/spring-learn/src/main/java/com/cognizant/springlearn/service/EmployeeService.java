package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.Employee;

@Service
public class EmployeeService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees()
	{
		return employeeDao.getAllEmployees();
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Start Service updateEmployee() method");
		LOGGER.info("End Service updateEmployee() method");
		return employeeDao.updateEmployee(employee);
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		LOGGER.info("Start Service deleteEmployee() method");
		employeeDao.deleteEmployee(id);
		LOGGER.info("End Service deleteEmployee() method");
	}
	
	
	public Employee getOneEmployee(int id) throws EmployeeNotFoundException
	{
		LOGGER.info("Start Service getOneEmployee() method");
		LOGGER.info("End Service getOneEmployee() method");
		return employeeDao.getOneEmployee(id);
	}
}
