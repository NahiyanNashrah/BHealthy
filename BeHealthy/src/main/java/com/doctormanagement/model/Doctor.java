package com.doctormanagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	String phonenumber,email,password,name,fee,location,number_of_patient,visiting_hour,degree,department;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	public Doctor(Long id, String phonenumber, String email, String password, String name, String fee, String location,
			String number_of_patient, String visiting_hour, String degree, String department) {
		this.id = id;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.name = name;
		this.fee = fee;
		this.location = location;
		this.number_of_patient = number_of_patient;
		this.visiting_hour = visiting_hour;
		this.degree = degree;
		this.department = department;
	}
	
	
	public Doctor(String phonenumber, String email, String password, String name, String fee, String location,
			String number_of_patient, String visiting_hour, String degree, String department) {
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.name = name;
		this.fee = fee;
		this.location = location;
		this.number_of_patient = number_of_patient;
		this.visiting_hour = visiting_hour;
		this.degree = degree;
		this.department = department;
	}
	
	public Doctor() {
		super();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFee() {
		return fee;
	}


	public void setFee(String fee) {
		this.fee = fee;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getNumber_of_patient() {
		return number_of_patient;
	}


	public void setNumber_of_patient(String number_of_patient) {
		this.number_of_patient = number_of_patient;
	}


	public String getVisiting_hour() {
		return visiting_hour;
	}


	public void setVisiting_hour(String visiting_hour) {
		this.visiting_hour = visiting_hour;
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


	public Set<Role> getRoles() {
	        return roles;
	    }
	 
	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }

}
