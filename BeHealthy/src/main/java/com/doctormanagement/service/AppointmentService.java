package com.doctormanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctormanagement.model.PatientList;
import com.doctormanagement.repository.PatientListRepository;

@Service
public class AppointmentService {
	
	@Autowired
	RemainingPatientService remainingPatientService;
	@Autowired
	PatientListService patientListService;
	@Autowired
	PatientListRepository patientListRepository;
	
	public Boolean makeAppointment(PatientList patient) {
		Boolean possible = remainingPatientService.isPossible(patient.getDoctorphonenumber(),patient.getDate());
//		System.out.println(possible);
		if(possible == true) {
			List <PatientList> p =  patientListRepository.findByDoctorphonenumberAndDate(patient.getDoctorphonenumber(), patient.getDate());
			int size = p.size();
			size = size + 1;
			patient.setSerial(String.valueOf(size));
			
			return patientListService.addPatientList(patient);
			
		}
		
		return false;
	}
}
