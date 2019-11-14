package com.doctormanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctormanagement.model.PrescriptionDetails;
import com.doctormanagement.repository.PrescriptionDetailesRepository;

@Service
public class PrescriptionService {
	
	@Autowired
	PrescriptionDetailesRepository prescriptionDetailesRepository;
	
	public List<PrescriptionDetails> getPrescription(String phonenumber){
		List <PrescriptionDetails> aa = prescriptionDetailesRepository.findByPhonenumber(phonenumber);
		return aa;
	}

}
