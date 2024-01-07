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

	@Query("SELECT p FROM PatientProcedure p WHERE p.procedurenumber.patientnumber = :patientId ORDER BY p.proceduredate DESC ,p.timestamp DESC ")
    List<PatientProcedure> findByProcedurenumber_Patientnum(@Param("patientId") int patientId);

	//List<PatientProcedure> findByProceduredateBetween(Date fromDate, Date toDate);
	
	 @Query("SELECT p FROM PatientProcedure p WHERE p.proceduredate BETWEEN :fromDate AND :toDate")
	    List<PatientProcedure> findByProceduredateBetween(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	    // Add a query to filter procedures based on session and proceduredate
	 @Query("SELECT p FROM PatientProcedure p WHERE p.proceduredate BETWEEN :fromDate AND :toDate AND " +
		        "((:session = 'both') OR " +
		        "(:session = 'morning' AND HOUR(p.timestamp) BETWEEN 0 AND 14) OR " +
		        "(:session = 'evening' AND HOUR(p.timestamp) BETWEEN 15 AND 23))")
		List<PatientProcedure> findByProceduredateBetweenAndSession(
		        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("session") String session);
	 
	 @Query("SELECT p FROM PatientProcedure p WHERE p.proceduredate BETWEEN :fromDate AND :toDate AND " +
		        "((:doctor = 'doctor1' AND  p.externaldoctor = 'doctor1') OR " +
		        "(:doctor = 'doctor2' AND p.externaldoctor = 'doctor2') OR " +
		        "(:doctor = 'doctor3' AND p.externaldoctor = 'doctor3') OR " +
		        "(:doctor = 'doctor4' AND p.externaldoctor = 'doctor4'))")
		List<PatientProcedure> findByProceduredateBetweenAndDoctor(
		        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("doctor") String doctor);
	 
	 @Query("SELECT p FROM PatientProcedure p " +
		        "WHERE p.proceduredate BETWEEN :fromDate AND :toDate AND " +
		        "((:lab = 'lab1' AND p.labname = 'lab1') OR " +
		        "(:lab = 'lab2' AND p.labname = 'lab2') OR " +
		        "(:lab = 'lab3' AND p.labname = 'lab3'))")
		List<PatientProcedure> findByProceduredateBetweenAndLab(
		        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("lab") String lab);



}

