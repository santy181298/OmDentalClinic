package com.Om.DentalClinic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.repository.PatientProcedureRepository;

@Service
public class PatientProcedureServiceImpl implements PatientProcedureService{
		
	@Autowired
	private PatientProcedureRepository patientProcedureRepository;
	
	public List<PatientProcedure> getAllPatietProcedures() {
		return patientProcedureRepository.findAll();
	}
		
	@Override
	public List<PatientProcedure> getAllPatientProcedures() {
		
		return patientProcedureRepository.findAll();
	}
	

	@Override
	public String savePatientProcedure(Date patientproceduredate,String patientproceduredetail,
			 double patientprocedureestimateamount,String patientprocedurepaymenttype,double patientprocedurepaymentamount,
			 String patientprocedurelabname)throws IOException {
		PatientProcedure patientProcedure=new PatientProcedure();
		patientProcedure.setPatientproceduredate(patientproceduredate);
		patientProcedure.setPatientproceduredetail(patientproceduredetail);
		patientProcedure.setPatientprocedureestimateamount(patientprocedureestimateamount);
		patientProcedure.setPatientprocedurepaymenttype(patientprocedurepaymenttype);
		patientProcedure.setPatientprocedurepaymentamount(patientprocedurepaymentamount);
		patientProcedure.setPatientprocedurelabname(patientprocedurelabname);
		
		patientProcedureRepository.save(patientProcedure);
		return "data saved successfully";
		
	}

}
