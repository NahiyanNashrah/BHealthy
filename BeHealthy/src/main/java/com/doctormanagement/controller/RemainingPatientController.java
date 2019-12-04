package com.doctormanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.doctormanagement.service.RemainingPatientService;

@RestController
public class RemainingPatientController {
	
	@Autowired
	RemainingPatientService remainingPatientService;
	
	@CrossOrigin
	@PreAuthorize("hasRole('DOCTOR')")
	@GetMapping("/api/addavailability/{doctorphonenumber}/{date}/{numberOfPatient}")
	public void addavailability(@PathVariable String doctorphonenumber,@PathVariable String date,@PathVariable String numberOfPatient) {
		remainingPatientService.addavailability(doctorphonenumber,date,numberOfPatient);
	}
}
