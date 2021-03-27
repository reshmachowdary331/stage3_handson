package com.cognizant.springlearn;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.controller.EmployeeController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
	
	@Autowired
	private CountryController countryController;
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoadsCountry() throws Exception {
		assertNotNull(countryController);
	}
	
	@Test 
	public void contextLoadsEmployee() throws Exception { 
		assertNotNull(employeeController); 
	} 
	
	@Test
	public void testGetCountry() throws Exception
	{
		ResultActions actions=mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
		actions.andExpect(jsonPath("$.name").exists());
		actions.andExpect(jsonPath("$.name").value("India"));
	}
	
	@Test
	public void testGetCountryException() throws Exception
	{
		ResultActions actions=mvc.perform(get("/countries/az"));
		actions.andExpect(status().isBadRequest());
		actions.andExpect(status().reason("Country Not Found"));
	}
	
	
	@Test
	public void testGetEmployeeException() throws Exception
	{
		ResultActions actions=mvc.perform(get("/employees/80"));
		actions.andExpect(status().isBadRequest());
		actions.andExpect(status().reason("Employee Not Found"));
	}

}
