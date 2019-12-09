package com.doctormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.Doctor;

import com.doctormanagement.service.DoctorListService;

@RestController
public class DoctorListController {

	@Autowired DoctorListService docListService;
	
	@CrossOrigin
	@RequestMapping("/api/auth/doctor-list")	
	public List<Doctor>getAllDoctor(){
		return docListService.getAllDoctor();
	}
	
	@CrossOrigin
	@RequestMapping("api/auth/find-doctor/{department}")
	public List<Doctor> getDoctorByDepartment(@PathVariable String department){
		return docListService.getDoctorByDepartment(department);
	}
}
