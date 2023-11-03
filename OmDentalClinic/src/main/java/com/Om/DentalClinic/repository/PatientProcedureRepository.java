package com.Om.DentalClinic.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Om.DentalClinic.model.PatientProcedure;

@Repository
public interface PatientProcedureRepository extends JpaRepository<PatientProcedure, Integer>{

	@Query("SELECT p FROM PatientProcedure p WHERE p.procedurenumber.patientnumber = :patientId ORDER BY p.proceduredate DESC")
    List<PatientProcedure> findByProcedurenumber_Patientnum(@Param("patientId") int patientId);

	//List<PatientProcedure> findByProceduredateBetween(Date fromDate, Date toDate);
	
	 @Query("SELECT p FROM PatientProcedure p WHERE p.proceduredate BETWEEN :fromDate AND :toDate")
	    List<PatientProcedure> findByProceduredateBetween(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	    // Add a query to filter procedures based on session and proceduredate
	    @Query("SELECT p FROM PatientProcedure p WHERE p.proceduredate BETWEEN :fromDate AND :toDate AND " +
	           "(:session = 'morning' AND HOUR(p.timestamp) >= 8 AND HOUR(p.timestamp) <= 14) OR " +
	           "(:session = 'evening' AND HOUR(p.timestamp) >= 15 AND HOUR(p.timestamp) <= 21)")
	    List<PatientProcedure> findByProceduredateBetweenAndSession(
	            @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("session") String session);
}

