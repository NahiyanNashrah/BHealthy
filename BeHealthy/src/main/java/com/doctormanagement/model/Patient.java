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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "patient")
public class Patient {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	String phonenumber,email,password,weight,name,bloodgroup,gender,address;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	int age;
	public Patient(Long id, String phonenumber, String email, String password, String weight, String name,
			String bloodgroup, String gender, String address, int age) {
//		super();
		this.id = id;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.weight = weight;
		this.name = name;
		this.bloodgroup = bloodgroup;
		this.gender = gender;
		this.address = address;
		this.age = age;
	}
	public Patient( String phonenumber, String email, String password, String weight, String name,
			String bloodgroup, String gender, String address, int age) {
//		super();
//		this.id = id;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.weight = weight;
		this.name = name;
		this.bloodgroup = bloodgroup;
		this.gender = gender;
		this.address = address;
		this.age = age;
	}
	public Patient() {
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
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	 public Set<Role> getRoles() {
	        return roles;
	    }
	 
	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }
	
	
	
	
	
}
