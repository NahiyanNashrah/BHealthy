package com.doctormanagement.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="patientlist")
public class PatientList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String doctorphonenumber;
	String patientname,patientphonenumber,date,serial;
	
	public PatientList(Long id, String doctorphonenumber, String patientname, String patientphonenumber, String date,
			String serial) {
		super();
		this.id = id;
		this.doctorphonenumber = doctorphonenumber;
		this.patientname = patientname;
		this.patientphonenumber = patientphonenumber;
		this.date = date;
		this.serial = serial;
	}

	public PatientList(String doctorphonenumber, String patientname, String patientphonenumber, String date,
			String serial) {
		super();
		this.doctorphonenumber = doctorphonenumber;
		this.patientname = patientname;
		this.patientphonenumber = patientphonenumber;
		this.date = date;
		this.serial = serial;
	}

	public PatientList(Long listid, String dphonenumber, String patientname, String pphonenumber, String date) {
		super();
		this.id = listid;
		this.doctorphonenumber = dphonenumber;
		this.patientname = patientname;
		this.patientphonenumber = pphonenumber;
		this.date = date;
	}
	public PatientList(String dphonenumber, String patientname, String pphonenumber, String date) {
		super();
		this.doctorphonenumber = dphonenumber;
		this.patientname = patientname;
		this.patientphonenumber = pphonenumber;
		this.date = date;
	}
	
	public PatientList() {
		super();
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
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPatientphonenumber() {
		return patientphonenumber;
	}
	public void setPatientphonenumber(String pphonenumber) {
		this.patientphonenumber = pphonenumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	
	
	 
	 
	 

}
