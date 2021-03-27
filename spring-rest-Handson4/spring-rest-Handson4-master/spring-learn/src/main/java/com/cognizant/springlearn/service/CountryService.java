package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;


@Service
public class CountryService 
{
	ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
	@SuppressWarnings("unchecked")
	List<Country> list=context.getBean("countryList",ArrayList.class);
	
	public Country getCountry(String code) throws CountryNotFoundException
	{
		
		Country country=null;
		
		
		for(Country c:list)
		{
			if(c.getCode().equalsIgnoreCase(code))
			{
				country=c;
			}
		}
		
		if(country==null)
		{
			throw new CountryNotFoundException();
		}
			
		return country;
		
	}
	
	public Country addCountry(Country country)
	{
		if(list.add(country))
		{
			return country;
		}
		return null;
	}
}
