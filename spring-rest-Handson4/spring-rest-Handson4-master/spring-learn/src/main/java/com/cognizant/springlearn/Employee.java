package com.cognizant.springlearn;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee 
{
	@NotNull
	@NumberFormat
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 1,max = 30)
	private String name;
	
	@NotNull
	@Min(value = 0)
	private double salary;
	
	@NotNull
	private String permanent;
	
	@NotNull
	private Department department;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "EST")
	private Date dateOfBirth;
	
	@NotNull
	private Skill skill;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(Employee.class);
	
	
	public Employee() {
		super();
		LOGGER.info("Employee Object Created");
	}
	public Employee(@NotNull int id, @NotNull @NotBlank @Size(min = 1, max = 30) String name,
			@NotNull @Min(0) double salary, @NotNull String permanent, @NotNull Department department, Date dateOfBirth,
			@NotNull Skill skill) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.department = department;
		this.dateOfBirth = dateOfBirth;
		this.skill = skill;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPermanent() {
		return permanent;
	}
	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", department=" + department + ", dateOfBirth=" + dateOfBirth + ", skill=" + skill + "]";
	}
	
	
}
