package com.Om.DentalClinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.repository.PatientInfoRepository;
import com.Om.DentalClinic.repository.PatientProcedureRepository;

@Service
public class PatientProcedureService {
	
	@Autowired
	private PatientProcedureRepository patientProcedureRepository;
	
	 @Autowired
	    public PatientProcedureService(PatientProcedureRepository patientProcedureRepository) {
	        this.patientProcedureRepository = patientProcedureRepository;
	    }

	    public List<PatientProcedure> getAllProcedures() {
	        return patientProcedureRepository.findAll();
	    }

	    public Optional<PatientProcedure> getProcedureById(int id) {
	        return patientProcedureRepository.findById(id);
	    }

	    public PatientProcedure createProcedure(PatientProcedure procedure) {
	    	// Set the relationship with PatientInfo
	      //  procedure.setProcedurepatientnumber(PatientInfoRepository.findByPatientnumber (procedure.getProcedurepatientnumber().getPatientnumber()));
	    	return patientProcedureRepository.save(procedure);
	    }

	    public PatientProcedure updateProcedure(int id, PatientProcedure procedure) {
	        if (patientProcedureRepository.existsById(id)) {
	            procedure.setProcedureid(id);
	            return patientProcedureRepository.save(procedure);
	        }
	        return null; // Handle error or throw exception
	    }

	    public void deleteProcedure(int id) {
	        patientProcedureRepository.deleteById(id);
	    }
	
}
