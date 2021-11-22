package com.qa.LukasSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.LukasSpring.domain.Book;
import com.qa.LukasSpring.exceptions.BookNotFoundException;
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
		
		return this.repo.findById(id).orElseThrow(BookNotFoundException::new);
	}
	
	public Book update(Long id, Book book) {
		
		Optional<Book> currentOptional = this.repo.findById(id);
		Book current = currentOptional.get();
		
		current.setBookName(book.getBookName());
		current.setAuthorName(book.getAuthorName());
		
		return this.repo.saveAndFlush(current);
	}
	
	public boolean delete(Long id) {
		
		this.repo.deleteLicenseById(id);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		//This should return false if it doesn't exist, so we invert it.
		return !exists;
	}
	
}
