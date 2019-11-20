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
	
	public List<PatientList>getAllPatient(String listId) {
		List<PatientList> list = new ArrayList<>(); 
		list = listRepository.findByDoctorphonenumber(listId)	;
		return list;
	}

}
