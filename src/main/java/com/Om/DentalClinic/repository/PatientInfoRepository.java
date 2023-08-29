package com.Om.DentalClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Om.DentalClinic.model.PatientInfo;

public interface PatientInfoRepository extends JpaRepository<PatientInfo,Long> {

}
