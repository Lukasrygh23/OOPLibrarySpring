package com.qa.LukasSpring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.LukasSpring.domain.Book;
import com.qa.LukasSpring.service.BookService;

@CrossOrigin
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

	@GetMapping("/getBook/{id}")
	public ResponseEntity<Book> getOne(@PathVariable Long id) {
		return new ResponseEntity<Book>(this.service.getOne(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
		return new ResponseEntity<Book>(this.service.update(id, book), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Book> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<Book>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
