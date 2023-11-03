package com.Om.DentalClinic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Om.DentalClinic.model.PatientInfo;

import com.Om.DentalClinic.repository.PatientInfoRepository;



@Service
public class PatientInfoServiceImpl implements PatientInfoService {
	
	@Autowired
	private PatientInfoRepository patientInfoRepository;
	
	public List<PatientInfo> getAllPatientInfo() {
		return patientInfoRepository.findAll();
	}
	
	public  List<PatientInfo> findAllByOrderByPatientregdateDesc(){
		return patientInfoRepository.findAllByOrderByPatientregdateDesc();
	}

	public void savePatientInfo(MultipartFile patientReports,String firstname,String middlename,String lastname,int patientage,String patientgender,Date patientregdate,long patientmobile1,long patientmobile2,String patientmedicalhistory) throws IOException {
		
		PatientInfo patientInfo = new PatientInfo();
		patientInfo.setPatientReports(patientReports.getBytes());
		patientInfo.setFirstname(firstname);
		patientInfo.setMiddlename(middlename);
		patientInfo.setLastname(lastname);
		patientInfo.setPatientage(patientage);
		patientInfo.setPatientgender(patientgender);
		patientInfo.setPatientregdate(patientregdate);
		patientInfo.setPatientmobile1(patientmobile1);
		patientInfo.setPatientmobile2(patientmobile2);
		patientInfo.setPatientmedicalhistory(patientmedicalhistory);
		
		patientInfoRepository.save(patientInfo);
		
	}

	public void deletePatientInfoById(int id) {
		this.patientInfoRepository.deleteById(id);
	}


	public PatientInfo getPatientInfoById(int id) {
		return patientInfoRepository.findById(id).orElse(null);
	}



}
