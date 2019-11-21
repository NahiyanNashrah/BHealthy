package com.doctormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.Doctor;
import com.doctormanagement.repository.DoctorRepository;

@RestController
public class DoctorController {

	@Autowired
	DoctorRepository doctorRepository;
	private List<Doctor> result;
	
	@CrossOrigin
	@GetMapping("/api/auth/home/doctor_list")
	public List<Doctor> getAllDoctor(){
		List<Doctor> all = doctorRepository.findAll();
//		result = null;
//		for(int i = 0 ;i<7;i++) {
//			result.add(all.get(i));
//		}
		return all;
		
	}
}
