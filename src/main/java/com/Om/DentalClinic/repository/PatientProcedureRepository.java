package com.Om.DentalClinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Om.DentalClinic.model.PatientProcedure;

@Repository
public interface PatientProcedureRepository extends JpaRepository<PatientProcedure, Integer>{

	@Query("SELECT p FROM PatientProcedure p WHERE p.procedurenumber.patientnumber = :patientId")
    List<PatientProcedure> findByProcedurenumber_Patientnum(@Param("patientId") int patientId);

}
