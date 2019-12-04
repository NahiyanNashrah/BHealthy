package com.doctormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doctormanagement.model.Doctor;

import com.doctormanagement.service.DoctorListService;

public class DoctorListController {

	@Autowired DoctorListService docListService;
	
	@RequestMapping("/api/auth/doctor-list")
	@CrossOrigin
	public List<Doctor>getAllDoctor(){
		return docListService.getAllDoctor();
	}
}
