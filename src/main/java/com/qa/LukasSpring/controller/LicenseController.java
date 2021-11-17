package com.qa.LukasSpring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.LukasSpring.domain.tLicense;
import com.qa.LukasSpring.service.LicenseService;

@RestController
@RequestMapping("/license")
public class LicenseController {
	
	private LicenseService service;
	
	public LicenseController(LicenseService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<tLicense> create(@RequestBody tLicense license) {
		
		return new ResponseEntity<tLicense>(this.service.create(license), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<tLicense>> getAll() {
		return new ResponseEntity<List<tLicense>>(this.service.getAll(), HttpStatus.OK);
	}

}
