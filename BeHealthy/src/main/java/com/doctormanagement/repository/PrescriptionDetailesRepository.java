package com.doctormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctormanagement.model.PrescriptionDetails;

public interface PrescriptionDetailesRepository extends JpaRepository<PrescriptionDetails, Long> {
	
}
