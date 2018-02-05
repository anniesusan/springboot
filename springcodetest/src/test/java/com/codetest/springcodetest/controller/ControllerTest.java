package com.codetest.springcodetest.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.codetest.springcodetest.ApplicationTests;
import com.codetest.springcodetest.domain.ConfigCreateRequest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControllerTest extends ApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void createConfig() throws Exception {
		ConfigCreateRequest configCreateRequest = new ConfigCreateRequest();
		configCreateRequest.setEndPoint("test");
		configCreateRequest.setEnv("test");
		configCreateRequest.setPort("test");

		String example = "{\"endPoint\":\"prod.can\",\"env\":\"prod\",\"port\":\"9098\"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("http://localhost:9098/api/testAppCode/config/testVersion").accept(MediaType.APPLICATION_JSON)
				.content(example).contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(post("http://localhost:9098/api/testAppCode/config/testVersion").contentType("application/json;charset=UTF-8")
				.content((example)));

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void getConfig() throws Exception {
		mockMvc.perform(get("http://localhost:9098/api/testAppCode/config/testVersion")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.env").value("prod")).andExpect(jsonPath("$.endPoint").value("prod.can"))
				.andExpect(jsonPath("$.port").value("9098"));

	}

	@Test
	public void getVersionList() throws Exception {
		mockMvc.perform(get("http://localhost:9098/api/abc/config/")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));

	}

}
