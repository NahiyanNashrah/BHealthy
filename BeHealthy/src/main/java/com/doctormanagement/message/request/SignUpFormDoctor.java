package com.doctormanagement.message.request;

import java.util.Set;

public class SignUpFormDoctor {

	String phonenumber,email,password,name,fee,location,number_of_patient,visiting_hour,degree,department;

	private Set<String> role ;

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
	
	 public Set<String> getRole() {
	        return role;
	    }
	 
	    public void setRoles(Set<String> role) {
	        this.role = role;
	    }
	
	

	
}
