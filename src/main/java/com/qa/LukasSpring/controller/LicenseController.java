package com.qa.LukasSpring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/get/{id}")
	public ResponseEntity<tLicense> getOne(@PathVariable Long id) {
		return new ResponseEntity<tLicense>(this.service.getOne(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<tLicense> update(@PathVariable Long id, @RequestBody tLicense license) {
		return new ResponseEntity<tLicense>(this.service.update(id, license), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<tLicense> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<tLicense>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<tLicense>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
