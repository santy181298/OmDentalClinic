package com.Om.DentalClinic.controller;

import java.io.IOException;

import java.security.Principal;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.model.User;
import com.Om.DentalClinic.repository.UserRepository;
import com.Om.DentalClinic.service.PatientInfoService;
import com.Om.DentalClinic.service.PatientProcedureService;
import com.Om.DentalClinic.service.PatientProcedureServiceImpl;
import com.Om.DentalClinic.service.UserServiceImpl;


import jakarta.servlet.http.HttpSession;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




@Controller
public class MainController {

	@Autowired
	private PatientInfoService patientInfoService;
	
	@Autowired
	private PatientProcedureService patientProcedureService;
	
	@Autowired
	private PatientProcedureServiceImpl patientProcedureServiceImpl;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	public MainController(UserServiceImpl userServiceImpl) {
	this.userServiceImpl=userServiceImpl;
	}
	

	
	 

//Controller for Login-----------------------------------------------------------------------------------------	
	 @GetMapping("/")
	 public String showLogin(Model model, HttpSession session) {

			return "login";

		}
	 
	 @GetMapping("/login")
	 public String showLogin() {

		 return "login";
	 }
	 
	 @GetMapping("/logout")
	    public String logout() {
	        // Add logout logic here
	        return "redirect:/";
	    }


	 @PostMapping("/login")
	    public String login(HttpServletRequest request, @RequestParam String username, @RequestParam String password, Model model) {
	        User user = userServiceImpl.findByUsername(username);

	        if (user != null && user.getPassword().equals(password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);

	            if ("ADMIN".equals(user.getRole())) {
	                return "redirect:/adminHome";
	            } else if ("RECEP1".equals(user.getRole()) || "RECEP2".equals(user.getRole()) || "RECEP3".equals(user.getRole())) {
	                // Update patient_info and patient_procedure tables

	                return "redirect:/userhome";
	            }
	        }

	        model.addAttribute("error", "Invalid username or password.");
	        return "login";
	    }
	 
	 
//User Controller------------------------------------------------------------------------------	 
	 		
	 @GetMapping("/adminHome")
	 public String adminHome(HttpServletRequest request, Model model)
	 {
		 HttpSession session = request.getSession();
	     String username = (String) session.getAttribute("username");

	     // Pass the username to the view
	     model.addAttribute("username", username);

		 return "adminHome";
	 }

	 
	 @GetMapping("/userhome")
	 public String userHome(HttpServletRequest request,Model model) {
		 HttpSession session = request.getSession();
	     String username = (String) session.getAttribute("username");

	     // Pass the username to the view
	     model.addAttribute("username", username);   
	     return "home"; 
	  }


//Controller for PatientInfo------------------------------------------------------------------------------	 
 
	 @GetMapping("/patientinfo")
	 public String showPatientinfo(HttpServletRequest request, Model model) {
		 HttpSession session = request.getSession();
	     String username = (String) session.getAttribute("username");

	     // Pass the username to the view
	     model.addAttribute("username", username); 
		 
	     PatientInfo patientinfo = new PatientInfo(); 
	     model.addAttribute("patientinfo", patientinfo);	     
	     return "patientinfo";
	 } 
	 
		@GetMapping("/patientList")
		public String showPatientList(HttpServletRequest request, Model model,Principal principal) {
			HttpSession session = request.getSession();
		     String username = (String) session.getAttribute("username");
		     
		     //get user by username
		     User user=userServiceImpl.findByUsername(username);
		     // Pass the user's role to the view
		     model.addAttribute("userRole", user.getRole());

		     // Pass the username to the view
		     model.addAttribute("username", username); 
		    model.addAttribute("listpatients", patientInfoService.findAllByOrderByPatientregdateDesc());
			return "patientList";
		}
		
		
		@GetMapping("/deletePatientInfo/{id}")
		public String deletePatientInfo(@PathVariable(value = "id") int id) {
			this.patientInfoService.deletePatientInfoById(id);
			return "redirect:/patientList";
		}
		
		@GetMapping("/editPatientinfo/{id}")
		public String editPatientInfoForm(HttpServletRequest request, @PathVariable("id") int id, Model model) {
			HttpSession session = request.getSession();
		     String username = (String) session.getAttribute("username");

		     // Pass the username to the view
		     model.addAttribute("username", username); 
			
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
		                              @RequestParam("patientregdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date patientregdate,
		                              @RequestParam("patientmobile1") long patientmobile1,
		                              @RequestParam("patientmobile2") long patientmobile2,
		                              @RequestParam("patientmedicalhistory") String patientmedicalhistory,
		                              HttpServletRequest request) throws IOException {
		    
		    // Get username from session
		    HttpSession session = request.getSession();
		    String username = (String) session.getAttribute("username");

		    // Save patient information along with the cashier's username
		    patientInfoService.savePatientInfo(patientReports, firstname, middlename, lastname, patientage, patientgender, patientregdate, patientmobile1, patientmobile2, patientmedicalhistory, username);
		    
		    return "redirect:/patientList";
		}
	
		 

		
		@PostMapping("/SavePatientInfo")
		public String savePatientInfo(@RequestParam("patientReports") MultipartFile patientReports,
		                              @RequestParam("firstname") String firstname,
		                              @RequestParam("middlename") String middlename,
		                              @RequestParam("lastname") String lastname,
		                              @RequestParam("patientage") int patientage,
		                              @RequestParam("patientgender") String patientgender,
		                              @RequestParam("patientregdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date patientregdate,
		                              @RequestParam("patientmobile1") long patientmobile1,
		                              @RequestParam("patientmobile2") long patientmobile2,
		                              @RequestParam("patientmedicalhistory") String patientmedicalhistory,
		                              HttpServletRequest request) throws IOException {
		    
		    // Get username from session
		    HttpSession session = request.getSession();
		    String username = (String) session.getAttribute("username");

		    // Save patient information along with the cashier's username
		    patientInfoService.savePatientInfo(patientReports, firstname, middlename, lastname, patientage, patientgender, patientregdate, patientmobile1, patientmobile2, patientmedicalhistory, username);
		    
		    return "redirect:/patientList";
		}

	
	
//PatientInfo Code Ends here----------------------------------------------------------------------------------------------
	

//PatientProcedure controller ------------------------------------------------------------------------------	
	
		
			 @GetMapping("/patientDetails/{patientId}")
			 public String showPatientDetail(HttpServletRequest request, @PathVariable("patientId") int patientId,Model model) {
				 HttpSession session = request.getSession();
			     String username = (String) session.getAttribute("username");
			     
			   //get user by username
			     User user=userServiceImpl.findByUsername(username);
			     // Pass the user's role to the view
			     model.addAttribute("userRole", user.getRole());

	
			     // Pass the username to the view
			     model.addAttribute("username", username); 
				 
				 List<PatientProcedure> patientProcedures = patientProcedureService.getProceduresByPatientId(patientId);
				 model.addAttribute("patientProcedures", patientProcedures);
				 return "patientDetails";
			 }
		
		
		   @GetMapping("/procedureDetails/{patientId}")
		   public String showProcedureDetail(HttpServletRequest request, @PathVariable("patientId") int patientId, Model model) {
			     HttpSession session = request.getSession();
			     String username = (String) session.getAttribute("username");

			     // Pass the username to the view
			     model.addAttribute("username", username); 
			   
			   PatientProcedure patientprocedure = new PatientProcedure();
		       model.addAttribute("patientprocedure", patientprocedure);
		       PatientInfo patientInfo = patientInfoService.getPatientInfoById(patientId);
		        model.addAttribute("patientinfo", patientInfo);
		       return "procedureDetails";
		   }



		   
		   @PostMapping("/SavePatientProcedure/{patientnumber}")
		   public String savePatientProcedure(
		           @ModelAttribute PatientProcedure patientProcedure,
		           @PathVariable("patientnumber") int patientNumber, HttpServletRequest request) {

		       // Get username from session
		       HttpSession session = request.getSession();
		       String username = (String) session.getAttribute("username");

		       // Fetch patient information
		       PatientInfo patientInfo = patientInfoService.getPatientInfoById(patientNumber);

		       // Set proc_cashier_name and procedure number
		       patientProcedure.setCashiername(username);
		       patientProcedure.setProcedurenumber(patientInfo);

		       // Save patient procedure
		       patientProcedureService.savePatientProcedure(patientProcedure);

		       return "redirect:/patientList";
		   }


		   


		   
//PatientProcedure controller ENDs		
	

	
		

}
