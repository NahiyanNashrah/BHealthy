package com.doctormanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.doctormanagement.model.Doctor;

import com.doctormanagement.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
@Service
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
	
	public List<Doctor> getDoctorByDepartment(String department){
		List <Doctor> list = new ArrayList<>();
		list = docRepository.findByDepartment(department);
		return list;
	}
}
