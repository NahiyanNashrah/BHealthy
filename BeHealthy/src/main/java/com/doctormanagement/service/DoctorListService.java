package com.doctormanagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.doctormanagement.model.Doctor;

import com.doctormanagement.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class DoctorListService {

	@Autowired DoctorRepository docRepository;
	
	public List<Doctor> getAllDoctor(){
		List <Doctor> list = new ArrayList<>();
		list = docRepository.findAll();
		return list;
		
	}
	
	public Boolean addDoctor(Doctor doctor) {
		docRepository.save(doctor);
		return true;
	}
}
