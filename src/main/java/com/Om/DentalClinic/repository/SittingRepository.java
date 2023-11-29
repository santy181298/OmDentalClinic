	package com.Om.DentalClinic.repository;
	
	import java.util.Date;
	import java.util.List;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;
	
	import com.Om.DentalClinic.model.Sittings;
	
	@Repository
	public interface SittingRepository extends JpaRepository<Sittings,Integer > {
		
		@Query("SELECT s FROM Sittings s WHERE s.sittingidproc.procedureid = :procedureid ORDER BY s.sittingdate DESC , s.timestamp DESC")
		List<Sittings> findBySittingid_Procedureid(@Param("procedureid") int procedureid );
		
		
		@Query("SELECT s FROM Sittings s WHERE s.sittingdate BETWEEN :fromDate AND :toDate AND " +
		        "(:session = 'morning' AND HOUR(s.timestamp) >= 8 AND HOUR(s.timestamp) <= 14) OR " +
		        "(:session = 'evening' AND HOUR(s.timestamp) >= 15 AND HOUR(s.timestamp) <= 21)")
		List<Sittings> findByDateBetweenAndSession(
		        @Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("session") String session);
	
	}
