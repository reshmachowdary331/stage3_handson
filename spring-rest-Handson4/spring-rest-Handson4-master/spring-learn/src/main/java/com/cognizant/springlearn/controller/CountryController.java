package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController 
{
	private static final Logger LOGGER=LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value = "/country",method = RequestMethod.GET)
	public Country getCountryIndia()
	{
		LOGGER.info("Start: getCountryIndia() method");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=context.getBean("country",Country.class);
		LOGGER.info("End: getCountryIndia() method");
		return country;
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	@GetMapping("/countries")
	public List<Country> getAllCountries()
	{
		LOGGER.info("Start: getAllCountries() method");
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		List<Country> list=(List<Country>) context.getBean("countryList",ArrayList.class);
		LOGGER.info("End: getAllCountries() method");
		return list;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		LOGGER.info("Start: getCountry() method");
		Country country=countryService.getCountry(code);
		LOGGER.info("End: getCountry() method");
		return country;
	}
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country)
	{
		LOGGER.info("Start: addCountry() method");
		Country c=countryService.addCountry(country);
		LOGGER.info("End: addCountry() method");
		return c;
		
	}
}
