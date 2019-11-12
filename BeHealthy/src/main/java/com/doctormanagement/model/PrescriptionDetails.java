package com.doctormanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prescription")
public class PrescriptionDetails {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 String phonenumber,doctor_name,department,date,image;

	public PrescriptionDetails(Long id, String phonenumber, String doctor_name, String department, String date,String image) {
		this.id = id;
		this.phonenumber = phonenumber;
		this.doctor_name = doctor_name;
		this.department = department;
		this.date = date;
		this.image = image;
	}

	public PrescriptionDetails(String phonenumber, String doctor_name, String department, String date) {
		this.phonenumber = phonenumber;
		this.doctor_name = doctor_name;
		this.department = department;
		this.date = date;
	}

	public PrescriptionDetails() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	 
	 
}
