package com.doctormanagement.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctormanagement.model.Doctor;
import com.doctormanagement.model.RemainPatientCount;
import com.doctormanagement.repository.DoctorRepository;
import com.doctormanagement.repository.PrescriptionDetailesRepository;
import com.doctormanagement.repository.RemainingPatientCountRepository;

@Service
public class RemainingPatientService {
	
	@Autowired 
	DoctorRepository doctorRepository;
	@Autowired
	RemainingPatientCountRepository remainingPatientCountRepository;
	
	public void addavailability(String dphonenumber) {
		Doctor d = doctorRepository.findByPhonenumber(dphonenumber);
		RemainPatientCount r = new RemainPatientCount(d.getPhonenumber(),nextDate(),d.getNumber_of_patient()); 
		remainingPatientCountRepository.save(r);
	}
	
	public String nextDate() {
    	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date(System.currentTimeMillis());
    	final Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.DAY_OF_YEAR, 1);
    	return formatter.format(calendar.getTime());
	}
	
}
