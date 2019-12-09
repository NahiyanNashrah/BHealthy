package com.doctormanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctormanagement.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByPhonenumber(String phonenumber);
    Boolean existsByPhonenumber(String phonenumber);
    Boolean existsByEmail(String email);

}
