package com.doctormanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "remainingpatient")
public class RemainPatientCount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	String dphonenumber,date,remaining;

	public RemainPatientCount(Long id, String dphonenumber, String date, String remaining) {
//		super();
		this.id = id;
		this.dphonenumber = dphonenumber;
		this.date = date;
		this.remaining = remaining;
	}
	
	
	public RemainPatientCount(String dphonenumber, String date, String remaining) {
//		super();
		this.dphonenumber = dphonenumber;
		this.date = date;
		this.remaining = remaining;
	}


	public RemainPatientCount() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDphonenumber() {
		return dphonenumber;
	}
	public void setDphonenumber(String dphonenumber) {
		this.dphonenumber = dphonenumber;
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
