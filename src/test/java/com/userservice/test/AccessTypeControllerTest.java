package com.userservice.test;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.userservice.controller.AccessTypeController;

/**
 * @author Gourav Singh
 * AccessType Controller Test Class
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AccessTypeController.class)
public class AccessTypeControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//				.alwaysDo(MockMvcResultHandlers.print())
				.build();
	}
	
	/**
	 * Get Access Types Controller Test
	 * @param
	 * @return 
	 * @throws Exception
	 */
	@Test
	public void getAccessTypes() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accesstypeservices/getallaccesstypes");
		
		this.mockMvc.perform(requestBuilder)
		.andExpect(status().is(200))
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.statusCode", is(2000)))
		.andExpect(jsonPath("$.statusMessage", is("Success")))
		.andExpect(jsonPath("$.result").isEmpty());
	}
	
	/**
	 * Add / Update Access Types Controller Test
	 * @param
	 * @return 
	 * @throws Exception
	 */
	@Test
	public void getAccessTypesInputParam() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accesstypeservices/getallaccesstypes?id=1");
		
		this.mockMvc.perform(requestBuilder)
		.andExpect(status().is(200));
	}
	
	/**
	 * Test case for bad get url requests
	 * @param
	 * @return 
	 * @throws Exception
	 */
	@Test
	public void badGetRequest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/accesstypeservices/aassdd");
		this.mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
	
	/**
	 * Test case for bad post url requests
	 * @param
	 * @return 
	 * @throws Exception
	 */
	@Test
	public void badPostRequest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/accesstypeservices/aassdd");
		this.mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}

}
