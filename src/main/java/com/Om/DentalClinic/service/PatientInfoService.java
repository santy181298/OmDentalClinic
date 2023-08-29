package com.Om.DentalClinic.service;

import java.util.List;

import com.Om.DentalClinic.model.PatientInfo;

public interface PatientInfoService {

	public List<PatientInfo> getAllPatientInfo();
	public void savePatientInfo(PatientInfo patientInfo) ;
	public PatientInfo getPatientInfoById(int id) ;
	public void deletePatientInfoById(int id) ;

}
