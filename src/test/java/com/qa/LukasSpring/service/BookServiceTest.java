package com.qa.LukasSpring.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.LukasSpring.domain.Book;
import com.qa.LukasSpring.repo.BookRepo;

//BE AWARE THIS IS THE UNIT TEST


@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	
	@InjectMocks
	private BookService service;
	
	@Mock
	private BookRepo repo;
	
	@Test
	public void createTest() {
		Book input = new Book("Trolley Problems", "Emmanuel Cant");
		Book output = new Book(1L, "Trolley Problems", "Emmanuel Cant");
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	@Test
	public void getAllTest() {
		//
		List<Book> output = new ArrayList<>();
		output.add(new Book("Trolley Problems", "Emannuel Cant"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	
	@Test
	public void getOneTest() {
		Book output = new Book(1L, "Trolley Problems", "Emmanuel Cant");
		Optional<Book> outputBook = Optional.of(output);
		Long bookId = 1L;
		
		Mockito.when(this.repo.findById(bookId)).thenReturn(outputBook);
		
		assertEquals(output, this.service.getOne(bookId));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(bookId);
		
	}
	
	@Test 
	public void testUpdate() {
		Long inputId = 1L;
		Book updated = new Book(1L, "Colony Problems", "CA");
		Optional<Book> existingOptional = Optional.of(new Book(1L, "Trolley Problems", "Emmanuel Cant"));
		
		Mockito.when(this.repo.findById(inputId)).thenReturn(existingOptional);
		Mockito.when(this.repo.saveAndFlush(updated)).thenReturn(updated);
		
		assertEquals(updated, this.service.update(inputId, updated));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(inputId);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(updated);
	}
	
	@Test
	public void testDelete() {
		Long inputId = 1L;
		boolean result = false;
		
		Mockito.when(this.repo.existsById(inputId)).thenReturn(result);
		
		assertTrue(this.service.delete(inputId));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(inputId);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(inputId);
		
	}
}
