package com.Om.DentalClinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Om.DentalClinic.model.Sittings;

@Repository
public interface SittingRepository extends JpaRepository<Sittings,Integer > {
	
	@Query("SELECT s FROM Sittings s WHERE s.sittingidproc.procedureid = :procedureid ORDER BY s.sittingdate DESC")
	List<Sittings> findBySittingid_Procedureid(@Param("procedureid") int procedureid );

}
