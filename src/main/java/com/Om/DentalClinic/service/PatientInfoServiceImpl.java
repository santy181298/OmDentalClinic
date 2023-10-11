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
 
	
	public void savePatientInfo(MultipartFile patientReports, String firstname, String middlename, String lastname,
            int patientage, String patientgender, Date patientregdate, long patientmobile1,
            long patientmobile2, String patientmedicalhistory, String cashierName) throws IOException {

			// Create a new PatientInfo instance
			PatientInfo patientInfo = new PatientInfo();
			// Set other fields in the patientInfo object using the provided parameters
			patientInfo.setFirstname(firstname);
			patientInfo.setMiddlename(middlename);
			patientInfo.setLastname(lastname);
			patientInfo.setPatientage(patientage);
			patientInfo.setPatientgender(patientgender);
			patientInfo.setPatientregdate(patientregdate);
			patientInfo.setPatientmobile1(patientmobile1);
			patientInfo.setPatientmobile2(patientmobile2);
			patientInfo.setPatientmedicalhistory(patientmedicalhistory);
			// Set the info_cashier_name
			patientInfo.setCashiername(cashierName);
			
			// Save the patientInfo object to the database
			patientInfoRepository.save(patientInfo);
			
			// Handle patientReports file if necessary
			// ...
		}

	public void deletePatientInfoById(int id) {
		this.patientInfoRepository.deleteById(id);
	}


	public PatientInfo getPatientInfoById(int id) {
		return patientInfoRepository.findById(id).orElse(null);
	}



}
