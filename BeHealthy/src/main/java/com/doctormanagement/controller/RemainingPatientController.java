package com.doctormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.repository.RemainingPatientRepository;
import com.doctormanagement.service.RemainingPatientService;
import com.doctormanagement.model.RemainingPatient;
@RestController
public class RemainingPatientController {
	
	@Autowired
	RemainingPatientService remainingPatientService;
	
	@Autowired
	RemainingPatientRepository remainingPatientRepository;
	
	
	@CrossOrigin
	@PreAuthorize("hasRole('DOCTOR')")
	@GetMapping("/api/addavailability/{doctorphonenumber}/{date}/{numberOfPatient}")
	public void addavailability(@PathVariable String doctorphonenumber,@PathVariable String date,@PathVariable String numberOfPatient) {
		remainingPatientService.addavailability(doctorphonenumber,date,numberOfPatient);
	}
	@CrossOrigin
	@GetMapping("/api/auth/getall/{doctorphonenumber}")
	public List<RemainingPatient> getAll(@PathVariable String doctorphonenumber) {
		return remainingPatientRepository.findByDoctorphonenumber(doctorphonenumber);
	}
}
