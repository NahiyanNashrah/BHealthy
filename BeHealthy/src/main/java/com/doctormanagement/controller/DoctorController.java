package com.doctormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return all;
		
	}
	
	@CrossOrigin
	@GetMapping("/api/auth/single_doctor/{phonenumber}")
	public Doctor getDoctor(@PathVariable String phonenumber) {
		return doctorRepository.findByPhonenumber(phonenumber);
		
	}
	
}
