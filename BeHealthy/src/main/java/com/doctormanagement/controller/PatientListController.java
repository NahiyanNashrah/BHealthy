package com.doctormanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	@RequestMapping("/api/patient_list/{doctorPhonenumber}")
	@PreAuthorize("hasRole('DOCTOR')")
	public List<PatientList> getAllPatient(@PathVariable String doctorPhonenumber){
//		SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
//    	Date date = new Date(System.currentTimeMillis());
//    	final Calendar calendar = Calendar.getInstance();
//    	calendar.setTime(date);
//    	String date1 = formatter.format(calendar.getTime());
		return listService.getAllPatientByDateDoctor(doctorPhonenumber,"19-12-2019");
		
	}
}
