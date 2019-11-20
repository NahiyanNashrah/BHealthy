package com.doctormanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.PatientList;
import com.doctormanagement.service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appiontmentService;
	
	@PostMapping("/api/makeappointment")
	@PreAuthorize("hasRole('PATIENT')")
	public Boolean makeAppointment( @RequestBody PatientList patient) {
		return appiontmentService.makeAppointment(patient);
		
	} 
}
