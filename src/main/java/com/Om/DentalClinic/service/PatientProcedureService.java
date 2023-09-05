package com.Om.DentalClinic.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import com.Om.DentalClinic.model.PatientProcedure;

public interface PatientProcedureService {
	
	public List<PatientProcedure> getAllPatientProcedures();
	
	//public String savePatientProcedure(PatientProcedure patientProcedure);
	
	public String savePatientProcedure(Date patientproceduredate,String patientproceduredetail,
									 double patientprocedureestimateamount,String patientprocedurepaymenttype,double patientprocedurepaymentamount,
									 String patientprocedurelabname) throws IOException;
}
