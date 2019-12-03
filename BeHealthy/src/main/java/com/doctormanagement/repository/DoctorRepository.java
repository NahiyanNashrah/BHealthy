package com.doctormanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.doctormanagement.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	Doctor findByPhonenumber(String phonenumber);
    Boolean existsByPhonenumber(String phonenumber);
	Boolean existsByEmail(String Email);
}
