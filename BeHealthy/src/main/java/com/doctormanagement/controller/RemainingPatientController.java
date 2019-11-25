package com.doctormanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.Doctor;
import com.doctormanagement.service.RemainingPatientService;

@RestController
public class RemainingPatientController {
	
	@Autowired
	RemainingPatientService remainingPatientService;
	
	@PreAuthorize("hasRole('DOCTOR')")
	@GetMapping("/api/addavailability/{doctorphonenumber}")
	public void addavailability(@PathVariable String doctorphonenumber) {
		remainingPatientService.addavailability(doctorphonenumber);
	}
}
