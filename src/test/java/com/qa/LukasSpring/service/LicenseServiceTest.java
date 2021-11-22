package com.qa.LukasSpring.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
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
import com.qa.LukasSpring.domain.tLicense;
import com.qa.LukasSpring.repo.LicenseRepo;

@RunWith(MockitoJUnitRunner.class)
public class LicenseServiceTest {
	
	@InjectMocks
	private LicenseService service;
	
	@Mock
	private LicenseRepo repo;

	@SuppressWarnings("deprecation")
	@Test
	public void createTest() {
		Date testTime = new Date(120, 11, 20);
		Book testBook = new Book(1L, "Herp", "Derp");
		tLicense input = new tLicense("Jimmy", testTime, testBook);
		tLicense output = new tLicense(1L, "Jimmy", testTime, testBook);
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getAllTest() {
		List<tLicense> output = new ArrayList<>();
		Date testTime = new Date(120, 11, 10);
		Book testBook = new Book(1L, "Herp", "Derp");
		output.add(new tLicense("James", testTime, testBook));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
				
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getOneTest() {
		Long testId = 1L;
		Book testBook = new Book(1L, "Test", "Not also test");
		Date testTime = new Date(120, 11, 10);
		tLicense license = new tLicense(1L, "Jesse", testTime, testBook);
		Optional<tLicense> optLicense = Optional.of(license);
		
		Mockito.when(this.repo.findById(testId)).thenReturn(optLicense);
		
		assertEquals(license, this.service.getOne(testId));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdate() {
		Long inputId = 1L;
		Book testBook = new Book(1L, "Test", "Also Test");
		Date testTime = new Date(120,11,10);
		Date updatedTime = new Date(120, 12, 10);
		tLicense old = new tLicense("Giovanni", testTime, testBook);
		tLicense updated = new tLicense("Meowth", updatedTime, testBook);
		Optional<tLicense> existingOptional = Optional.of(old);
		
		Mockito.when(this.repo.findById(inputId)).thenReturn(existingOptional);
		Mockito.when(this.repo.saveAndFlush(updated)).thenReturn(updated);
		
		assertEquals(updated, this.service.update(inputId, updated));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(inputId);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(updated);
		
	}
	
	@Test
	public void testDelete () {
		Long inputId = 1L;
		boolean result = false;
		
		Mockito.when(this.repo.existsById(inputId)).thenReturn(result);
		
		assertTrue(this.service.delete(inputId));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(inputId);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(inputId);
	}
}
