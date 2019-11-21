package com.doctormanagement.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctormanagement.model.Doctor;
import com.doctormanagement.model.RemainingPatient;
import com.doctormanagement.repository.DoctorRepository;
import com.doctormanagement.repository.RemainingPatientRepository;

@Service
public class RemainingPatientService {
	
	@Autowired 
	DoctorRepository doctorRepository;
	@Autowired
	RemainingPatientRepository remainingPatientRepository;
	
	public void addavailability(String dphonenumber) {
		Doctor d = doctorRepository.findByPhonenumber(dphonenumber);
		RemainingPatient r = new RemainingPatient(d.getPhonenumber(),nextDate(),d.getNumber_of_patient()); 
		remainingPatientRepository.save(r);
	}
	
	
	
	
	public String nextDate() {
    	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date(System.currentTimeMillis());
    	final Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.DAY_OF_YEAR, 1);
    	return formatter.format(calendar.getTime());
	}
	
	public Boolean isPossible(String doctorphonenumber,String date) {
		RemainingPatient remain =  remainingPatientRepository.findByDoctorphonenumberAndDate(doctorphonenumber,date);
		int patientNumber = Integer.parseInt(remain.getRemaining());
		if(patientNumber>0) {
			reducePatientList(remain);
			return true;
		}
		return false;
	}
	
	public void reducePatientList(RemainingPatient p) {
		int r = Integer.parseInt(p.getRemaining());
		r = r-1;
		p.setRemaining(String.valueOf(r));
		
	}
	
	
	
}
