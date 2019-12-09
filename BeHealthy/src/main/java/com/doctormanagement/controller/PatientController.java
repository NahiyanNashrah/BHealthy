package com.doctormanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.Patient;
import com.doctormanagement.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	PatientRepository patientRepository;
	
	
	@CrossOrigin
	@RequestMapping("api/auth/single_patient/{phonenumber}")
	public Patient getProfile(@PathVariable String phonenumber) {
		return patientRepository.findByPhonenumber(phonenumber);
	}
	
}
