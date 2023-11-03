package com.Om.DentalClinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Om.DentalClinic.model.PatientInfo;

public interface PatientInfoRepository extends JpaRepository<PatientInfo,Integer> {

    @Query("SELECT p FROM PatientInfo p ORDER BY p.patientregdate DESC")
    List<PatientInfo> findAllByOrderByPatientregdateDesc();
    
    
}
