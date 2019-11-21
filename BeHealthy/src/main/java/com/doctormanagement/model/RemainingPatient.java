package com.doctormanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "remainingpatient")
public class RemainingPatient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	String doctorphonenumber,date,remaining;

	public RemainingPatient(Long id, String dphonenumber, String date, String remaining) {
//		super();
		this.id = id;
		this.doctorphonenumber = dphonenumber;
		this.date = date;
		this.remaining = remaining;
	}
	
	
	public RemainingPatient(String dphonenumber, String date, String remaining) {
//		super();
		this.doctorphonenumber = dphonenumber;
		this.date = date;
		this.remaining = remaining;
	}


	public RemainingPatient() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDoctorphonenumber() {
		return doctorphonenumber;
	}
	public void setDoctorphonenumber(String dphonenumber) {
		this.doctorphonenumber = dphonenumber;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemaining() {
		return remaining;
	}
	public void setRemaining(String remaining) {
		this.remaining = remaining;
	}
	
	
	
	
	
}
