package com.cognizant.springlearn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;

public class Skill 
{
	@NotNull
	@NumberFormat
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 1,max = 30)
	private String name;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(Department.class);
	
	
	public Skill() {
		super();
		LOGGER.info("Department Object Created");
	}
	public Skill(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
}
