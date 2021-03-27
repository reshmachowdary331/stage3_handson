package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao 
{
	private static List<Employee> EMPLOYEE_LIST=new ArrayList<Employee>();
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeDao.class);
	
	@SuppressWarnings({ "resource", "unchecked" })
	public EmployeeDao()
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("employee.xml");
		
		EMPLOYEE_LIST=(List<Employee>) context.getBean("employeeList");
		
		LOGGER.info("Employees:{}",EMPLOYEE_LIST);
	}
	
	public List<Employee> getAllEmployees()
	{
		return EMPLOYEE_LIST;
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Inside updateEmployee() method");
		for(Employee emp:EmployeeDao.EMPLOYEE_LIST)
		{
			if(emp.getId()==employee.getId())
			{
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setPermanent(employee.getPermanent());
				emp.setDepartment(employee.getDepartment());
				emp.setSkill(employee.getSkill());
				
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		Employee emp=null;
		for(Employee e:EMPLOYEE_LIST)
		{
			if(e.getId()==id)
			{
				emp=e;
				EMPLOYEE_LIST.remove(emp);
				break;
			}
		}
		if(emp==null)
		{
			throw new EmployeeNotFoundException();
		}
	}
	
	public Employee getOneEmployee(int id) throws EmployeeNotFoundException
	{
		for(Employee e:EMPLOYEE_LIST)
		{
			if(e.getId()==id)
			{
				return e;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
}
