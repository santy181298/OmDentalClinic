package com.Om.DentalClinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.repository.PatientInfoRepository;


public class PatientInfoServiceImpl implements PatientInfoService {
	
	@Autowired
	private PatientInfoRepository patientInfoRepository;
	
	public List<PatientInfo> getAllPatientInfo() {
		return patientInfoRepository.findAll();
	}

	public void savePatientInfo(PatientInfo patientInfo) {
		this.patientInfoRepository.save(patientInfo);
	}

	public PatientInfo getPatientInfoById(int id) {
		return patientInfoRepository.findById(id).orElse(null);
	}

	public void deletePatientInfoById(int id) {
		this.patientInfoRepository.deleteById(id);
	}


}
