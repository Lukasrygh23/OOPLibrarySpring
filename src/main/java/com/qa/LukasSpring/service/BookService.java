package com.qa.LukasSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.LukasSpring.domain.Book;
import com.qa.LukasSpring.repo.BookRepo;

@Service
public class BookService {

	private BookRepo repo;
	
	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}
	
	//Creation!
	public Book create(Book book) {
		
		return this.repo.saveAndFlush(book);
	}
	
	//ReadAll
	public List<Book> getAll() {
		return this.repo.findAll();
	}
	
	public Book getOne(Long id) {
		
		//TODO add custom exception
		return this.repo.findById(id).orElseThrow();
	}
	
	public Book update(Long id, Book book) {
		
		return this.repo.saveAndFlush(null);
	}
	
	public boolean delete(Long id) {
		
		
		return false;
	}
	
}
