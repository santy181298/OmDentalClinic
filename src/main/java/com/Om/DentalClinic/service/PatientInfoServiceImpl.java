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

	public void updatePatientInfo(
	        int patientNumber, // Add the patient number as a parameter to identify the patient to update
	        MultipartFile patientReports, 
	        String firstname,
	        String middlename,
	        String lastname,
	        int patientage,
	        String patientgender,
	        Date patientregdate,
	        long patientmobile1,
	        long patientmobile2,
	        String patientmedicalhistory,
	        String cashierName) throws IOException {

	    // Find the existing patient information by ID
	    PatientInfo existingPatientInfo = patientInfoRepository.findById(patientNumber)
	            .orElseThrow();

	    // Update the patient information fields
	    existingPatientInfo.setFirstname(firstname);
	    existingPatientInfo.setMiddlename(middlename);
	    existingPatientInfo.setLastname(lastname);
	    existingPatientInfo.setPatientage(patientage);
	    existingPatientInfo.setPatientgender(patientgender);
	    existingPatientInfo.setPatientregdate(patientregdate);
	    existingPatientInfo.setPatientmobile1(patientmobile1);
	    existingPatientInfo.setPatientmobile2(patientmobile2);
	    existingPatientInfo.setPatientmedicalhistory(patientmedicalhistory);
	    existingPatientInfo.setCashiername(cashierName);

	    // Update the patientReports if a new file is provided
	    if (patientReports != null && !patientReports.isEmpty()) {
	        existingPatientInfo.setPatientReports(patientReports.getBytes());
	    }

	    // Save the updated patient information
	    patientInfoRepository.save(existingPatientInfo);
	}


}
