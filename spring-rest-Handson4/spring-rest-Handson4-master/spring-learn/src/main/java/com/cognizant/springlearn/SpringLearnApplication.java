package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(scanBasePackages = "com.cognizant.springlearn")
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class); 


	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate2();
		displayDate();
		displayCountry();
		displayCountries();
	}
	
	/*public static void displayDate2() throws Exception
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml"); 
		SimpleDateFormat format=context.getBean("dateFormat",SimpleDateFormat.class);
		Date d=format.parse("31/12/2018");
		System.out.println(d);
	}*/
	
	@SuppressWarnings("resource")
	public static void displayDate() throws ParseException
	{
		LOGGER.info("START displayDate()"); 
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml"); 
		SimpleDateFormat format=context.getBean("dateFormat",SimpleDateFormat.class);
		LOGGER.debug("Date :{}",format.parse("31/12/2018"));
		LOGGER.info("END displayDate()"); 

	}
	
	@SuppressWarnings("resource")
	public static void displayCountry()
	{
		LOGGER.info("START displayCountry()");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country)context.getBean("country",Country.class);
		Country anotherCountry=(Country)context.getBean("country",Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Country : {}", anotherCountry.toString());
		LOGGER.info("END displayCountry()"); 
	}
	
	@SuppressWarnings({ "resource", "unchecked" })
	public static void displayCountries()
	{
		LOGGER.debug("START displayCountries()");
		//Initialize the context
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");		
		ArrayList<Country> countryList= context.getBean("countryList",ArrayList.class);
		LOGGER.debug("Country List : {} ", countryList);
		LOGGER.debug("END displayCountries()");
	}
	
	

}
