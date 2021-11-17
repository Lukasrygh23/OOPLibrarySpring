package com.qa.LukasSpring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.LukasSpring.domain.Book;
import com.qa.LukasSpring.domain.tLicense;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
//Runs the SQL scripts before each method.
@Sql(scripts= {"classpath:account-schema.sql",
		"classpath:account-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class LicenseControllerIntegrationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void testCreate() throws Exception {
		Book testBook = new Book(1L, "big book of tests", "GLADOS");
		Date testDate = new Date(120, 11, 10);
		tLicense testLicense = new tLicense("KantBeSerious", testDate, testBook);
		String testLicenseAsJSON = this.mapper.writeValueAsString(testLicense);
		RequestBuilder request = post("/license/create").contentType(MediaType.APPLICATION_JSON).content(testLicenseAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		tLicense savedLicense = new tLicense(2L, "KantBeSerious", testDate, testBook);
		String savedLicenseAsJSON = this.mapper.writeValueAsString(savedLicense);
		
		ResultMatcher checkBody = content().json(savedLicenseAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetOne() throws Exception {
		Book testBook = new Book(1L, "big book of tests", "GLADOS");
		Date testDate = new Date(122, 0, 20);
		tLicense testLicense = new tLicense("Chell", testDate, testBook);
		String testLicenseAsJSON = this.mapper.writeValueAsString(testLicense);
		RequestBuilder request = get("/license/get/1");
		
		ResultMatcher checkStatus = status().isOk();
		
		ResultMatcher checkBody = content().json(testLicenseAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		Book testBook = new Book(1L, "big book of tests", "GLADOS");
		Date testDate = new Date(120, 1, 20);
		tLicense testLicense = new tLicense("Chell", testDate, testBook);
		String testLicenseAsJSON = this.mapper.writeValueAsString(testLicense);
		RequestBuilder request = get("/license/getAll");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testLicenseAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testUpdate() throws Exception {
		Book testBook = new Book(1L, "big book of tests", "GLADOS");
		Date testDate = new Date(120, 1, 15);
		tLicense testLicense = new tLicense("Wheatley", testDate, testBook);
		String testLicenceAsJSON = this.mapper.writeValueAsString(testLicense);
		RequestBuilder request = put("/license/update/1").contentType(MediaType.APPLICATION_JSON).content(testLicenceAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		tLicense lSaved = new tLicense(1L, "Wheatley", testDate, testBook);
		String lSavedAsJSON = this.mapper.writeValueAsString(lSaved);
		
		ResultMatcher checkBody = content().json(lSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/license/delete/1")).andExpect(status().isNoContent());
	}
	
	
}
