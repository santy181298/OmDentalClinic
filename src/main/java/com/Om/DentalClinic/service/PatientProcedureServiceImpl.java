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
import com.Om.DentalClinic.repository.PatientProcedureRepository;


@Service
public class PatientProcedureServiceImpl implements PatientProcedureService{
		
	@Autowired
	private PatientProcedureRepository patientProcedureRepository;

	
	@Override
	public List<PatientProcedure> getAllPatientProcedures() {
	
		return patientProcedureRepository.findAll();
	}


	@Override
	public void savePatientProcedure(PatientProcedure patientProcedure) {
	
		patientProcedureRepository.save(patientProcedure);
	}

//	public String savePatientProcedure(PatientInfo patientprocedurenumber, Date patientproceduredate,String patientproceduredetail,
//			 double patientprocedureestimateamount,String patientprocedurepaymenttype,double patientprocedurepaymentamount,
//			 String patientprocedurelabname)throws IOException {
//		PatientProcedure patientProcedure=new PatientProcedure();
//		
//		patientProcedureRepository.save(patientProcedure);
//		return "Data saved successfully";
//	}

	
	
}
