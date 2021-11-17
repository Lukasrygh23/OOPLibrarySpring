package com.qa.LukasSpring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.LukasSpring.domain.Book;
import com.qa.LukasSpring.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Book> create(@RequestBody Book book) {
		
		return new ResponseEntity<Book>(this.service.create(book), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Book>> getAll() {
		
		return new ResponseEntity<List<Book>>(this.service.getAll(), HttpStatus.OK);
	}
}
