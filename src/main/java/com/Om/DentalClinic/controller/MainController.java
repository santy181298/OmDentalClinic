package com.Om.DentalClinic.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.service.PatientInfoService;
import com.Om.DentalClinic.service.PatientProcedureService;


@RestController
public class MainController {

	@Autowired
	private PatientInfoService patientInfoService;
	
	@Autowired
	private PatientProcedureService patientProcedureService;
	
	@GetMapping("/listPatientInfo")
	public List<PatientInfo> getAllPatientInfo() {		
		return  this.patientInfoService.getAllPatientInfo();
	}	
	
	
	// Patient Procedure Controller
		@GetMapping("/home")
		public String procedureHome() {
			return "This is Patient Procedure home page";
			
		}
		
	 @GetMapping("/")
	    public List<PatientProcedure> getAllProcedures() {
	        return patientProcedureService.getAllProcedures();
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

	
>>>>>>> branch 'master' of https://github.com/santy181298/OmDentalClinic.git
}
