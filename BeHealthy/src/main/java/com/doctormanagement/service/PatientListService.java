package com.doctormanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctormanagement.model.PatientList;
import com.doctormanagement.repository.PatientListRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientListService {
	
	
	@Autowired
	private PatientListRepository listRepository;
	
	public List<PatientList>getAllPatientByDateDoctor(String doctorPhonenumber,String date) {
		List<PatientList> list = new ArrayList<>(); 
		list = listRepository.findByDoctorphonenumberAndDate(doctorPhonenumber,date)	;
		return list;
	}
	
	public Boolean addPatientList(PatientList patient) {
		listRepository.save(patient);
		return true;
	}
	
	public List<PatientList> getAllPatientUsingPhonenumber (String phonenumber){
		return listRepository.findByPatientphonenumber(phonenumber);
	}
	
}
