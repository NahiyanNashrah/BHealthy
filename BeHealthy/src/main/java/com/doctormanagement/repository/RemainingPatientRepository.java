package com.doctormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.doctormanagement.model.RemainingPatient;

public interface RemainingPatientRepository extends CrudRepository<RemainingPatient, Long>{
	RemainingPatient findByDoctorphonenumberAndDate(String phonenumber,String date);
}
