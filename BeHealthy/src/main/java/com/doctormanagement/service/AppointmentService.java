package com.doctormanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctormanagement.model.PatientList;

@Service
public class AppointmentService {
	
	@Autowired
	RemainingPatientService remainingPatientService;
	@Autowired
	PatientListService patientListService;
	
	public Boolean makeAppointment(PatientList patient) {
		Boolean possible = remainingPatientService.isPossible(patient.getDoctorphonenumber(),patient.getDate());
		if(possible == true) {
			return patientListService.addPatientList(patient);
			
		}
		
		return false;
	}
}
