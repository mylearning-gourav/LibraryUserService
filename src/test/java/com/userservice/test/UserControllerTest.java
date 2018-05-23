package com.userservice.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.userservice.bean.ResultBean;
import com.userservice.controller.UserController;
import com.userservice.entity.User;
import com.userservice.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
//@WebAppConfiguration
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private UserController userController;
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	@MockBean
	private UserService userService;
	
	User user = null;
	ResultBean resultBean  = null;
	ArrayList<Object> userList = new ArrayList<Object>();
	Map<String, ArrayList<Object>> mapList = new HashMap<String, ArrayList<Object>>();
	
	@Before
	public void setup() {
		user = new User(1, "Gourav Singh", "gouravsingh@gmail.com", "gourav", true);
		userList.add(user);
		mapList.put("User List", userList);
		resultBean = new ResultBean(100, "Success", (HashMap<String, ArrayList<Object>>) mapList);
//		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void getAllUsersTest() throws Exception {
		
		// studentService.addCourse to respond back with mockCourse
		Mockito.when(userService.getAllUser()).thenReturn((ArrayList<Object>) userList);
		
		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.get("/userservices/getallusers");
				/*.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);*/
		
		this.mockMvc.perform(requestBuilder)
			.andExpect(status().is(200))
			.andExpect(content().contentType("application/json;charset=UTF-8"));

		/*MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/students/Student1/courses/1",
				response.getHeader(HttpHeaders.LOCATION));*/
		
		/*this.mockMvc.perform(get("/userservices/getallusers"))
			.andExpect(status().is(200))
			.andExpect(content().contentType("application/json;charset=UTF-8"));*/
	}

	/*
	 * Test case for wrong get URL
	 */
	@Test
	public void noRequestFoundGet() throws Exception {	
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/hgh/aassdd");
		this.mockMvc.perform(requestBuilder)
			.andExpect(status().isNotFound());
	}
	
	/*
	 * Test case for wrong post URL
	 */
	@Test
	public void noRequestFoundPost() throws Exception {	
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/hgh/aassdd");
		this.mockMvc.perform(requestBuilder)
			.andExpect(status().isNotFound());
	}
	
	/*
	 * Test case for bad get url requests
	 */
	@Test
	public void badGetRequest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/userservices/aassdd");
		this.mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
	
	/*
	 * Test case for bad post url requests
	 */
	@Test
	public void badPostRequest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/userservices/aassdd");
		this.mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
}