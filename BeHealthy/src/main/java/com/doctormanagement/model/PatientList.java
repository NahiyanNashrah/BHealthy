package com.doctormanagement.model;

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
@Table(name="patientlist")
public class PatientList {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long listid;
	
	 private Long did;
	 String patientname,phonenumber;
	 
	public PatientList(Long listid, Long did, String patientname, String phonenumber) {
		//super();
		this.listid = listid;
		this.did = did;
		this.patientname = patientname;
		this.phonenumber = phonenumber;
	}

	public PatientList(Long did, String patientname, String phonenumber) {
//		super();
		this.did = did;
		this.patientname = patientname;
		this.phonenumber = phonenumber;
	}

	
	
	public PatientList() {
		
	}

	public Long getListid() {
		return listid;
	}

	public void setListid(Long listid) {
		this.listid = listid;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	 
	
	 
	 
	 
}
