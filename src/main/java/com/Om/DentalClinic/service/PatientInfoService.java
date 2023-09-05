package com.Om.DentalClinic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;

public interface PatientInfoService {

	public List<PatientInfo> getAllPatientInfo();

	public String savePatientInfo(MultipartFile file,String patientnumber,String patientname,int patientage, String patientgender,Date patientregdate,Long patientmobile,String patientmedicalhistory) throws IOException;
//	public PatientInfo getPatientInfoById(Long id) ;
//	public void deletePatientInfoById(Long id) ;

	

}

