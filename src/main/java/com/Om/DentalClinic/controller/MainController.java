package com.Om.DentalClinic.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.service.PatientInfoService;
import com.Om.DentalClinic.service.PatientProcedureService;
import com.Om.DentalClinic.service.PatientProcedureServiceImpl;


@RestController
public class MainController {

	@Autowired
	private PatientInfoService patientInfoService;
	
	@Autowired
	private PatientProcedureService patientProcedureService;
	
	@Autowired
	private PatientProcedureServiceImpl patientProcedureServiceImpl;
	
	
	@GetMapping("/listPatientInfo")
	public List<PatientInfo> getAllPatientInfo() {		
		return  this.patientInfoService.getAllPatientInfo();
	}	
	
	
	// Patient Procedure Controller
		@GetMapping("/procedure")
		public String procedureHome() {
			return "This is Patient Procedure home page";
			
		}
		
			
	 @GetMapping("/list_Patient_Procedure")
	    public List<PatientProcedure> getAllPatietProcedures() {
		 
	        return this.patientProcedureServiceImpl.getAllPatietProcedures();
	 }
	 
//	 @PostMapping("/savePatientProcedure")
//		public String savePatientProcedure(@ModelAttribute("patientProcedure") PatientProcedure patientProcedure) {
//			
//			return patientProcedureServiceImpl.savePatientProcedure(patientProcedure);
//		}
	 
	 @PostMapping("/savePatientProcedure")
		public String savePatientProcedure(
				@RequestParam("patientproceduredate")Date patientproceduredate,
				@RequestParam("patientproceduredetail")String patientproceduredetail,
				@RequestParam("patientprocedureestimateamount")double patientprocedureestimateamount,
				@RequestParam("patientprocedurepaymenttype")String patientprocedurepaymenttype,
				@RequestParam("patientprocedurepaymentamount")double patientprocedurepaymentamount,
				@RequestParam("patientprocedurelabname")String patientprocedurelabname) throws IOException
		{
			return patientProcedureService.savePatientProcedure(patientproceduredate, patientproceduredetail, patientprocedureestimateamount, patientprocedurepaymenttype, patientprocedurepaymentamount, patientprocedurelabname);
		}


	@PostMapping("/SavePatientInfo")
	public String savePatientInfo(@RequestParam("file") MultipartFile file,
	@RequestParam("patientnumber") String patientnumber,
	@RequestParam("patientname") String patientname,
	@RequestParam("patientage") int patientage,
	@RequestParam("patientgender") String patientgender,
	@RequestParam("patientregdate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date patientregdate,
	@RequestParam("patientmobile") Long patientmobile,
	@RequestParam("patientmedicalhistory") String patientmedicalhistory) throws IOException
	{
		return patientInfoService.savePatientInfo(file,patientnumber,patientname,patientage,patientgender,patientregdate,patientmobile,patientmedicalhistory);
	}

	
}
