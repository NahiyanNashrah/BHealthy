package com.doctormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.doctormanagement.model.RemainPatientCount;

public interface RemainingPatientCountRepository extends CrudRepository<RemainPatientCount, Long>{

}
