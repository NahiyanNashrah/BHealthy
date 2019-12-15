package com.doctormanagement.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.doctormanagement.model.RemainingPatient;
import com.doctormanagement.model.RemainingPatient;
public interface RemainingPatientRepository extends CrudRepository<RemainingPatient, Long>{
	RemainingPatient findByDoctorphonenumberAndDate(String phonenumber,String date);
	List<RemainingPatient> findByDoctorphonenumber(String doctorphonenumber);
}
