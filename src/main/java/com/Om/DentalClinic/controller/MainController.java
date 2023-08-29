package com.Om.DentalClinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.service.PatientInfoService;

@RestController
public class MainController {

	@Autowired
	private PatientInfoService patientInfoService;
	
	
	@GetMapping("/listPatientInfo")
	public List<PatientInfo> getAllPatientInfo() {		
		return  this.patientInfoService.getAllPatientInfo();
	}	
	
	
	
}
