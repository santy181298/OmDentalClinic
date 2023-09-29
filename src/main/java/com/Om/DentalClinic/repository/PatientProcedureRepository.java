package com.Om.DentalClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Om.DentalClinic.model.PatientProcedure;

@Repository
public interface PatientProcedureRepository extends JpaRepository<PatientProcedure, Integer>{

	
}
