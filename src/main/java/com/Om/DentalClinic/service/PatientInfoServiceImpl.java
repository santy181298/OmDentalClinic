package com.Om.DentalClinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.repository.PatientInfoRepository;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {
	
	@Autowired
	private PatientInfoRepository patientInfoRepository;
	
	public List<PatientInfo> getAllPatientInfo() {
		return patientInfoRepository.findAll();
	}

	public void savePatientInfo(PatientInfo patientInfo) {
		this.patientInfoRepository.save(patientInfo);
	}

	public PatientInfo getPatientInfoById(Long id) {
		return patientInfoRepository.findById(id).orElse(null);
	}

	public void deletePatientInfoById(Long id) {
		this.patientInfoRepository.deleteById(id);
	}


}
