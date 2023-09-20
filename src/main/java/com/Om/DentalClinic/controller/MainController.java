package com.Om.DentalClinic.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 
	
//	 @GetMapping("/patientDetails")
//	 public String showPatientDetail(Model model) {
//		 model.addAttribute("listPatientProcedures", patientProcedureServiceImpl.getAllPatientProcedures());
//		 return "patientDetails";
//	 }
	 @GetMapping("/login")
	 public String showLogin() {
		 return "login";
	 }
	
//	@GetMapping("/listPatientInfo")
//	public List<PatientInfo> getAllPatientInfo() {		
//		return  this.patientInfoService.getAllPatientInfo();
//	}	

			

//	 @GetMapping("/list_Patient_Procedure")
//	    public List<PatientProcedure> getAllPatietProcedures() {	 
//	        return this.patientProcedureServiceImpl.getAllPatientProcedures();
//	 }
//	 
	 @GetMapping("/")
	 public String home()
	 {
		 return "home";
	 }


	

// Santosh's Controller for PatientInfo------------------------------------------------------------------------------	 
 
	 @GetMapping("/patientinfo")
	 public String showPatientinfo(Model model) {
	     PatientInfo patientinfo = new PatientInfo(); 
	     model.addAttribute("patientinfo", patientinfo);	     
	     return "patientinfo";
	 } 
	 
		@GetMapping("/patientList")
		public String showPatientList(Model model) {
			model.addAttribute("listpatients", patientInfoService.getAllPatientInfo());
			return "patientList";
		}
		
		
		@GetMapping("/deletePatientInfo/{id}")
		public String deletePatientInfo(@PathVariable(value = "id") int id) {
			this.patientInfoService.deletePatientInfoById(id);
			return "redirect:/patientList";
		}
		
		@GetMapping("/editPatientinfo/{id}")
		public String editPatientInfoForm(@PathVariable("id") int id, Model model) {
			PatientInfo patientinfo = patientInfoService.getPatientInfoById(id);
			model.addAttribute("patientinfo", patientinfo);
			return "editPatientInfo";
		}
		
		
		@PostMapping("/updatePatientInfo")
		public String updatePatientInfo(@RequestParam("patientReports") MultipartFile patientReports,
		@RequestParam("firstname") String firstname,
		@RequestParam("middlename") String middlename,
		@RequestParam("lastname") String lastname,
		@RequestParam("patientage") int patientage,
		@RequestParam("patientgender") String patientgender,
		@RequestParam("patientregdate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date patientregdate,
		@RequestParam("patientmobile1") int patientmobile1,
		@RequestParam("patientmobile2") int patientmobile2,
		@RequestParam("patientmedicalhistory") String patientmedicalhistory) throws IOException
		{
		    if (patientReports.isEmpty()) {
		        return "redirect:/patientinfo?fileError=1";
		    }
			 patientInfoService.savePatientInfo(patientReports,firstname,middlename,lastname,patientage,patientgender,patientregdate,patientmobile1,patientmobile2,patientmedicalhistory);
			
			 return"redirect:/patientList";
		}
	
		 
		@PostMapping("/SavePatientInfo")
		public String savePatientInfo(@RequestParam("patientReports") MultipartFile patientReports,
		@RequestParam("firstname") String firstname,
		@RequestParam("middlename") String middlename,
		@RequestParam("lastname") String lastname,
		@RequestParam("patientage") int patientage,
		@RequestParam("patientgender") String patientgender,
		@RequestParam("patientregdate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date patientregdate,
		@RequestParam("patientmobile1") int patientmobile1,
		@RequestParam("patientmobile2") int patientmobile2,
		@RequestParam("patientmedicalhistory") String patientmedicalhistory) throws IOException
		{
		    if (patientReports.isEmpty()) {
		        return "redirect:/patientinfo?fileError=1"; // Redirect with an error code
		    }
			 patientInfoService.savePatientInfo(patientReports,firstname,middlename,lastname,patientage,patientgender,patientregdate,patientmobile1,patientmobile2,patientmedicalhistory);
			
			 return"redirect:/patientList";
		}
	
	
	
	@GetMapping("/adminHome")
	 public String adminHome()
	 {
		 return "adminHome";
	 }
		
	
//PatientInfo Code Ends here----------------------------------------------------------------------------------------------
	

//PatientProcedure controller ------------------------------------------------------------------------------	
	
	 @GetMapping("/procedureDetails")
	 public String showProcedureDetail(Model model) {
		 PatientProcedure  patientprocedure = new  PatientProcedure();
		 model.addAttribute("patientprocedure",patientprocedure);
		 return "procedureDetails";
	 }
	 
	 
	@PostMapping("/SavePatientProcedure")
	public String savePatientProcedure(  @ModelAttribute("patientProcedure") PatientProcedure patientProcedure) {

		        patientProcedureService.savePatientProcedure(patientProcedure);

		        return "redirect:/procedureDetails"; 
		    }

	 
//PatientProcedure controller ENDs	
	
	
	
	
	
	
}
