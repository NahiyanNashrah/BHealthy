package com.doctormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.PatientList;
import com.doctormanagement.service.PatientListService;

@RestController
public class PatientListController {

	
	@Autowired
	private PatientListService listService;
	
	@CrossOrigin
	@RequestMapping("/api/patient_list/{doctorPhonenumber}/{date}")
	@PreAuthorize("hasRole('DOCTOR')")
	public List<PatientList> getAllPatient(@PathVariable String doctorPhonenumber,@PathVariable String date){
		return listService.getAllPatientByDateDoctor(doctorPhonenumber,date);
		
	}
}
