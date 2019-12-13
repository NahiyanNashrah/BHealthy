package com.doctormanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seriallist")

public class SerialShow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String doctorPhonenumber,doctorname,location,fee,degree,department,visiting_time,serial;
	String patientPhonenumber,date;
	public SerialShow(Long id, String doctorPhonenumber, String doctorname, String location, String fee, String degree,
			String department, String visiting_time, String patientPhonenumber, String date,String serial) {
		super();
		this.id = id;
		this.doctorPhonenumber = doctorPhonenumber;
		this.doctorname = doctorname;
		this.location = location;
		this.fee = fee;
		this.degree = degree;
		this.department = department;
		this.visiting_time = visiting_time;
		this.patientPhonenumber = patientPhonenumber;
		this.date = date;
		this.serial = serial;
	}
	public SerialShow(String doctorPhonenumber, String doctorname, String location, String fee, String degree,
			String department, String visiting_time, String patientPhonenumber, String date,String serial) {
		super();
		this.doctorPhonenumber = doctorPhonenumber;
		this.doctorname = doctorname;
		this.location = location;
		this.fee = fee;
		this.degree = degree;
		this.department = department;
		this.visiting_time = visiting_time;
		this.patientPhonenumber = patientPhonenumber;
		this.date = date;
		this.serial = serial;
	}
	public SerialShow() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDoctorPhonenumber() {
		return doctorPhonenumber;
	}
	public void setDoctorPhonenumber(String doctorPhonenumber) {
		this.doctorPhonenumber = doctorPhonenumber;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getVisiting_time() {
		return visiting_time;
	}
	public void setVisiting_time(String visiting_time) {
		this.visiting_time = visiting_time;
	}
	public String getPatientPhonenumber() {
		return patientPhonenumber;
	}
	public void setPatientPhonenumber(String patientPhonenumber) {
		this.patientPhonenumber = patientPhonenumber;
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
