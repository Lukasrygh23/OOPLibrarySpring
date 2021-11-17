package com.qa.LukasSpring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
//Runs the SQL scripts before each method.
@Sql(scripts= {"classpath:account-schema.sql",
		"classpath:account-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class BookControllerIntegrationTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void testCreate() throws Exception {
		Book testBook = new Book ("Trolley Problematic", "Emmanuel Kant");
		String testBookAsJSON = this.mapper.writeValueAsString(testBook);
		RequestBuilder request = post("/book/create").contentType(MediaType.APPLICATION_JSON).content(testBookAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Book savedBook = new Book(2L, "Trolley Problematic", "Emmanuel Kant");
		String bookSavedAsJSON = this.mapper.writeValueAsString(savedBook);
		
		ResultMatcher checkBody = content().json(bookSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
		}
	
	@Test
	void testGet() throws Exception {
		Book testGLADOS = new Book(1L, "big book of tests", "GLADOS");
		String testGLADOSAsJSON = this.mapper.writeValueAsString(testGLADOS);
		RequestBuilder request = get("/user/getBook/1");
		
		ResultMatcher checkStatus = status().isOk();
		
		ResultMatcher checkBody = content().json(testGLADOSAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	void testGetAll() throws Exception {
		Book testBook = new Book(1L, "big book of tests", "GLADOS");
		String testBookAsJSON = this.mapper.writeValueAsString(List.of(testBook));
		RequestBuilder request = get("/book/getAll");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);		
	}
	
	@Test
	void testUpdate() throws Exception {
		Book updateTest = new Book("Trolleys and Portals", "GLADOS");
		String updateTestAsJSON = this.mapper.writeValueAsString(updateTest);
		RequestBuilder request = put("/book/update/1").contentType(MediaType.APPLICATION_JSON).content(updateTestAsJSON);
			
		ResultMatcher checkStatus = status().isAccepted();
		
		Book bookSaved = new Book(1L, "Trolleys and Portals", "GLADOS");
		String bookSavedAsJSON = this.mapper.writeValueAsString(bookSaved);
		
		ResultMatcher checkBody = content().json(bookSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/book/delete/1")).andExpect(status().isNoContent());
		
	}
}
