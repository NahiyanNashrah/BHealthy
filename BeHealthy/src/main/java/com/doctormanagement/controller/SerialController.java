package com.doctormanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.Doctor;
import com.doctormanagement.model.PatientList;
import com.doctormanagement.model.SerialShow;
import com.doctormanagement.repository.DoctorRepository;
import com.doctormanagement.service.PatientListService;

@RestController
public class SerialController {
	
	@Autowired
	PatientListService patientListService;
	
	@Autowired
	DoctorRepository docRepository;
//	private SerialShow tempSerial;
//	private List<SerialShow> sh;
	
	@CrossOrigin
	@GetMapping("api/getallserial/{phonenumber}")
	@PreAuthorize("hasRole('PATIENT')")
	public List<SerialShow> getAllSerial (@PathVariable String phonenumber) {
		
		List<SerialShow> sh = new ArrayList<>();
		List<PatientList> temp = patientListService.getAllPatientUsingPhonenumber(phonenumber);
		for(int i = 0; i<temp.size();i++) {
			PatientList p = temp.get(i);
			SerialShow tempSerial = new SerialShow();
			Doctor d = docRepository.findByPhonenumber(p.getDoctorphonenumber());
			tempSerial.setDoctorPhonenumber(p.getDoctorphonenumber());
			tempSerial.setDoctorname(d.getName());
			tempSerial.setSerial(p.getSerial());
			tempSerial.setDepartment(d.getDepartment());
			tempSerial.setLocation(d.getLocation());
			tempSerial.setFee(d.getFee());
			tempSerial.setDegree(d.getDegree());
			tempSerial.setVisiting_time(d.getVisiting_hour());
			tempSerial.setDate(p.getDate());
			tempSerial.setPatientPhonenumber(p.getPatientphonenumber());
			sh.add(tempSerial);
		}
		return sh;
	}
}
