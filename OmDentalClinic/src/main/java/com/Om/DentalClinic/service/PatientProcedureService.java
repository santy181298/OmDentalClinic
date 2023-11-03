package com.Om.DentalClinic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;

public interface PatientProcedureService {
	
	public List<PatientProcedure> getAllPatientProcedures();
	
	public void savePatientProcedure(PatientProcedure patientProcedure);
	
	public List<PatientProcedure> getProceduresByPatientId(int patientId);

	public void deletePatientProcedureById(int id);
	
	public PatientProcedure getPatientProcedureById(int id);
	
	public List<PatientProcedure> getFilteredProcedures(Date fromDate, Date toDate, String session);

}
