package com.Om.DentalClinic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.Om.DentalClinic.model.PatientInfo;
public interface PatientInfoService {

	public List<PatientInfo> getAllPatientInfo();

	public void savePatientInfo(MultipartFile patientReports,String firstname,String middlename,String lastname,int patientage, String patientgender,Date patientregdate,int patientmobile1,int patientmobile2,String patientmedicalhistory) throws IOException;
//	public PatientInfo getPatientInfoById(Long id) ;
//	public void deletePatientInfoById(Long id) ;

	

}

