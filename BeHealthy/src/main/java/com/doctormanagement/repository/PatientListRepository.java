package com.doctormanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctormanagement.model.PatientList;

public interface PatientListRepository extends JpaRepository <PatientList,Long> {
	
	public List<PatientList>findByDoctorphonenumber(String listId);

	
}
