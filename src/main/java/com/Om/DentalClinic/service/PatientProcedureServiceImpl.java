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
	
	@Autowired
	private PatientInfoRepository patientInfoRepository;

	
//	@Override
//	public List<PatientProcedure> getAllPatientProcedures() {
//		
//		return patientProcedureRepository.findAll();
//	}
	@Override
	public List<PatientProcedure> getAllPatientProcedures() {
		// TODO Auto-generated method stub
		return patientProcedureRepository.findAll();
	}
	
	@Override
	public String savePatientProcedure(String patientNumber, Date patientProcedureDate, String patientProcedureDetail,
            double patientProcedureEstimateAmount, String patientProcedurePaymentType,
            double patientProcedurePaymentAmount, String patientProcedureLabName) throws IOException {
		PatientInfo patientInfo = patientInfoRepository.findByPatientnumber(patientNumber);

		if (patientInfo == null) {
			return "Patient with patient number " + patientNumber + " not found.";
		}

		PatientProcedure patientProcedure = new PatientProcedure();
		patientProcedure.setPatientprocedurenumber(patientInfo);
		patientProcedure.setPatientproceduredate(patientProcedureDate);
		patientProcedure.setPatientproceduredetail(patientProcedureDetail);
		patientProcedure.setPatientprocedureestimateamount(patientProcedureEstimateAmount);
		patientProcedure.setPatientprocedurepaymenttype(patientProcedurePaymentType);
		patientProcedure.setPatientprocedurepaymentamount(patientProcedurePaymentAmount);
		patientProcedure.setPatientprocedurelabname(patientProcedureLabName);

		patientProcedureRepository.save(patientProcedure);
		return "Data saved successfully";
	}

}
