package com.Om.DentalClinic.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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



@Controller
public class MainController {

	@Autowired
	private PatientInfoService patientInfoService;
	
	@Autowired
	private PatientProcedureService patientProcedureService;
	@Autowired
	private PatientProcedureServiceImpl patientProcedureServiceImpl;
//	@GetMapping("/listPatientInfo")
//	public List<PatientInfo> getAllPatientInfo() {		
//		return  this.patientInfoService.getAllPatientInfo();
//	}	
	
	
//	// Patient Procedure Controller
//		@GetMapping("/home")
//		public String procedureHome() {
//			return "This is Patient Procedure home page";
//			
//		}
//		
//	 @GetMapping("/")
//	    public List<PatientProcedure> getAllProcedures() {
//	        return patientProcedureService.getAllProcedures();
//	 }
	@Autowired
	private PatientProcedureServiceImpl patientProcedureServiceImpl1;

	 
	 @GetMapping("/procedureDetails")
	 public String showProcedureDetail() {
		 return "procedureDetails";
	 }
	 @GetMapping("/patientDetails")
	 public String showPatientDetail(Model model) {
		 model.addAttribute("listPatientProcedures", patientProcedureServiceImpl.getAllPatientProcedures());
		 return "patientDetails";
	 }
	 @GetMapping("/login")
	 public String showLogin() {
		 return "login";
	 }

	 @GetMapping("/patientList")
	 public String showPatientList() {
		 return "patientList";
	 }
	
	@GetMapping("/listPatientInfo")
	public List<PatientInfo> getAllPatientInfo() {		
		return  this.patientInfoService.getAllPatientInfo();
	}	

			

	 @GetMapping("/list_Patient_Procedure")
	    public List<PatientProcedure> getAllPatietProcedures() {
		 
	        return this.patientProcedureServiceImpl.getAllPatientProcedures();
	 }
	 
	 @GetMapping("/")
	 public String home()
	 {
		 return "home";
	 }

	 
	 @PostMapping("/savePatientProcedure")
		public String savePatientProcedure(
				@RequestParam("patientprocedurenumber")PatientInfo patientprocedurenumber,
				@RequestParam("patientproceduredate")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date patientproceduredate,
				@RequestParam("patientproceduredetail")String patientproceduredetail,
				@RequestParam("patientprocedureestimateamount")double patientprocedureestimateamount,
				@RequestParam("patientprocedurepaymenttype")String patientprocedurepaymenttype,
				@RequestParam("patientprocedurepaymentamount")double patientprocedurepaymentamount,
				@RequestParam("patientprocedurelabname")String patientprocedurelabname) throws IOException
		{
			return patientProcedureService.savePatientProcedure(patientprocedurenumber,patientproceduredate, patientproceduredetail, patientprocedureestimateamount, patientprocedurepaymenttype, patientprocedurepaymentamount, patientprocedurelabname);
		}

// Santosh's Controller for PatientInfo------------------------------------------------------------------------------	 
 
	 @GetMapping("/patientinfo")
	 public String showPatientinfo(Model model) {
	     PatientInfo patientinfo = new PatientInfo(); 
	     model.addAttribute("patientinfo", patientinfo);	     
	     return "patientinfo";
	 } 
	 
//	@GetMapping("/listPatientInfo")
//	public List<PatientInfo> getAllPatientInfo() {		
//		return  this.patientInfoService.getAllPatientInfo();
//	}	
	
	
	
	@PostMapping("/SavePatientInfo")
	public String savePatientInfo(@RequestParam("patientReports") MultipartFile patientReports,
	@RequestParam("patientnumber") String patientnumber,
	@RequestParam("patientname") String patientname,
	@RequestParam("patientage") int patientage,
	@RequestParam("patientgender") String patientgender,
	@RequestParam("patientregdate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date patientregdate,
	@RequestParam("patientmobile") Long patientmobile,
	@RequestParam("patientmedicalhistory") String patientmedicalhistory) throws IOException
	{
	    if (patientReports.isEmpty()) {
	        return "redirect:/patientinfo?fileError=1"; // Redirect with an error code
	    }
		 patientInfoService.savePatientInfo(patientReports,patientnumber,patientname,patientage,patientgender,patientregdate,patientmobile,patientmedicalhistory);
		
		 return"redirect:/patientinfo";
	}
		
	
	
//PatientInfo Code Ends here----------------------------------------------------------------------------------------------
	
}
