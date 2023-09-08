package com.Om.DentalClinic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.repository.PatientInfoRepository;


@Service
public class PatientInfoServiceImpl implements PatientInfoService {
	
	@Autowired
	private PatientInfoRepository patientInfoRepository;
	
	public List<PatientInfo> getAllPatientInfo() {
		return patientInfoRepository.findAll();
	}



	public void savePatientInfo(MultipartFile patientReports,String patientnumber,String patientname,int patientage,String patientgender,Date patientregdate,Long patientmobile,String patientmedicalhistory) throws IOException {
		
		PatientInfo patientInfo = new PatientInfo();
		patientInfo.setPatientReports(patientReports.getBytes());
		patientInfo.setPatientnumber(patientnumber);
		patientInfo.setPatientname(patientname);
		patientInfo.setPatientage(patientage);
		patientInfo.setPatientgender(patientgender);
		patientInfo.setPatientregdate(patientregdate);
		patientInfo.setPatientmobile(patientmobile);
		patientInfo.setPatientmedicalhistory(patientmedicalhistory);
		
		patientInfoRepository.save(patientInfo);
		
	}




	
//	public PatientInfo getPatientInfoById(Long id) {
//		return patientInfoRepository.findById(id).orElse(null);
//	}
//
//	public void deletePatientInfoById(Long id) {
//		this.patientInfoRepository.deleteById(id);
//	}


}
