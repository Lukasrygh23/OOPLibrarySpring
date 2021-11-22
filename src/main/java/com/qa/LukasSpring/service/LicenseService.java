package com.qa.LukasSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.LukasSpring.domain.tLicense;
import com.qa.LukasSpring.repo.LicenseRepo;

@Service
public class LicenseService {
	
	private LicenseRepo repo;
	
	public LicenseService(LicenseRepo repo) {
		super();
		this.repo = repo;
	}
	
	public tLicense create(tLicense license) {
		return this.repo.saveAndFlush(license);
	}
	
	public List<tLicense> getAll() {
		return this.repo.findAll();
	}
	
	public tLicense getOne(Long id) {
		
		return this.repo.findById(id).orElseThrow();
		
	}
	
	public tLicense update(Long id, tLicense license) {
		Optional<tLicense> currentLicense = this.repo.findById(id);
		tLicense current = currentLicense.get();
		
		current.setRecipientUsername(license.getRecipientUsername());
		current.setReturnDate(license.getReturnDate());
		
		return this.repo.saveAndFlush(current);
		
	}
	
	public boolean delete(Long id) {
		
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
		
	}
	
}
