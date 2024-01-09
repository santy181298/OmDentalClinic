	package com.Om.DentalClinic.repository;
	
	import java.util.Date;
	import java.util.List;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;

import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.model.Sittings;
	
	@Repository
	public interface SittingRepository extends JpaRepository<Sittings,Integer > {
		
		@Query("SELECT s FROM Sittings s WHERE s.sittingidproc.procedureid = :procedureid ORDER BY s.sittingdate DESC , s.timestamp DESC")
		List<Sittings> findBySittingid_Procedureid(@Param("procedureid") int procedureid );
		
		
		@Query("SELECT s FROM Sittings s WHERE s.sittingdate BETWEEN :fromDate AND :toDate AND " +
		        "((:session = 'both') OR " +
				"(:session = 'morning' AND HOUR(s.timestamp) BETWEEN 0 AND 14) OR " +
		        "(:session = 'evening' AND HOUR(s.timestamp) BETWEEN 15 AND 23))")
		List<Sittings> findByDateBetweenAndSession(
		        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("session") String session);
		
		@Query("SELECT s FROM Sittings s WHERE s.sittingdate BETWEEN :fromDate AND :toDate AND " +
		        "((:doctor = 'Dr. Sameet Khode' AND  s.sittingexternaldoctor = 'Dr. Sameet Khode') OR " +
		        "(:doctor = 'Dr. Amogh Katre' AND  s.sittingexternaldoctor = 'Dr. Amogh Katre') OR " +
		        "(:doctor = 'Dr. Ajay Mohite' AND  s.sittingexternaldoctor = 'Dr. Ajay Mohite') OR " +
		        "(:doctor = 'Dr. Dheeraj Wagh' AND  s.sittingexternaldoctor = 'Dr. Dheeraj Wagh'))")
		List<Sittings> findByDateBetweenAndDoctor(
		        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("doctor") String doctor);
		
		@Query("SELECT s FROM Sittings s WHERE s.sittingdate BETWEEN :fromDate AND :toDate AND " +
		        "((:lab = 'Narkar Lab' AND s.sittinglabname = 'Narkar Lab') OR " +
		        "(:lab = 'Shivajimore Lab' AND s.sittinglabname = 'Shivajimore Lab') OR " +
		        "(:lab = 'Sandeep Kamble Lab' AND s.sittinglabname = 'Sandeep Kamble Lab'))")
		List<Sittings> findByDateBetweenAndLab(
		        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("lab") String lab);

	
	}
