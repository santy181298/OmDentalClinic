package com.Om.DentalClinic.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;

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
import org.springframework.web.servlet.ModelAndView;

import com.Om.DentalClinic.model.Appointment;
import com.Om.DentalClinic.model.PatientInfo;
import com.Om.DentalClinic.model.PatientProcedure;
import com.Om.DentalClinic.model.User;
import com.Om.DentalClinic.repository.PatientInfoRepository;
import com.Om.DentalClinic.repository.UserRepository;
import com.Om.DentalClinic.service.AppointmentService;
import com.Om.DentalClinic.service.PatientInfoService;
import com.Om.DentalClinic.service.PatientProcedureService;
import com.Om.DentalClinic.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;


@Controller
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private PatientInfoService patientInfoService;
	
	@Autowired
	private PatientProcedureService patientProcedureService;
		
	@Autowired
	private PatientInfoRepository patientInfoRepository;
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	

//Controller for Login-----------------------------------------------------------------------------------------	

	@GetMapping("/")
	 public String showLogin(Model model, HttpSession session) {
		User user=new User();
		model.addAttribute("user", user);
			return "login";

		}
	 
	@GetMapping("/login")
	public ModelAndView homepage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
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

	 // Registration Controller (Prasad)
		@GetMapping("/register")
		public String home(HttpServletRequest request, Model model) {
			HttpSession session = request.getSession();
		     String username = (String) session.getAttribute("username");
		     
		     if(username!=null) {
		    	 model.addAttribute("username", username);
				 return "register";
		     }
		     model.addAttribute("error","User Not Found");
				return "redirect:/login";
		}
		
		@PostMapping("/register")
		public String create(@ModelAttribute("users") User user, HttpSession session) {
			
			
			boolean u = userServiceImpl.checkUsername(user.getUsername());
			if (u) {
				System.out.println("User is already exist");
			} else {
				System.out.println(user);
				// password encryption
				//user.setPassword(bp.encode(user.getPassword()));
				// user.setRole(user.getRole());
				
//				if("ADMIN".equals(user.getRole())) {
//					// Perform the registration process for "ADMIN" users
//		            // For example, you can save the user to the database here
//					userRepository.save(user);
//				}else {
//					// If the user's role is not "ADMIN," redirect them to the login page
//		            return "redirect:/login?accessdenied";
//				}

				session.setAttribute("msg", "Registration  successfully!");
				userRepository.save(user);
			}

			return "register";
		}
	 
		@GetMapping("/accessDenied")
		public String errorpage() {
			return "accessdenied";
		}
		 
	 
//User Controller------------------------------------------------------------------------------	 
	 		
	 @GetMapping("/adminHome")
	 public String adminHome(HttpServletRequest request, Model model){
		 HttpSession session = request.getSession();
	     String username = (String) session.getAttribute("username");
	     
	     if(username!=null) {
	    	 model.addAttribute("username", username);
			 return "adminHome";
	     }
	     model.addAttribute("error","User Not Found");
			return "redirect:/login";
	     

	 }

	 
	 @GetMapping("/userhome")
	 public String userHome(HttpServletRequest request,Model model) {
		 HttpSession session = request.getSession();
	     String username = (String) session.getAttribute("username");
	     
	     if(username!=null) {
	    	 model.addAttribute("username", username);
			 return "home";
	     }
	     model.addAttribute("error","User Not Found");
			return "redirect:/login";


	  }


//Controller for PatientInfo------------------------------------------------------------------------------	 
 
	 @GetMapping("/patientinfo")
	 public String showPatientinfo(HttpServletRequest request, Model model) {
		 HttpSession session = request.getSession();
	     String username = (String) session.getAttribute("username");
	     
	     // 
	     if(username!=null) {
	    	  PatientInfo patientinfo = new PatientInfo();
	    	  if(patientinfo!=null) {

	 	    	model.addAttribute("username", username);
	 	    	model.addAttribute("patientinfo", patientinfo);
	 			return "patientinfo";
	    	  }
	    	
	     }
	     model.addAttribute("error","User Not Found");
			return "redirect:/login";
	     
	     

	 } 
	 
	
	 @GetMapping("/patientList")
		public String showPatientList(HttpServletRequest request, Model model,Principal principal) {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");		     
			
			if(username!=null) {
				User user=userServiceImpl.findByUsername(username);
				if(user !=null) {
					model.addAttribute("userRole", user.getRole());
					model.addAttribute("username", username);
					model.addAttribute("listpatients", patientInfoService.findAllByOrderByPatientregdateDesc());
					return "patientList";
					
				}
				
			}
 
			model.addAttribute("error","User Not Found");
			return "redirect:/login";
		    
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
		     
		    // by prasad 
		    if(username!=null) {
		    	PatientInfo patientinfo = patientInfoService.getPatientInfoById(id);
				if(patientinfo !=null) {
					
					model.addAttribute("username", username);
					model.addAttribute("patientinfo", patientinfo);
					return "editPatientInfo";
					
				}
				
			}
 
			model.addAttribute("error","User Not Found");
			return "redirect:/login";

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
		                                @RequestParam("patientnumber") int patientnumber,
		                                HttpServletRequest request) throws IOException {
		    HttpSession session = request.getSession();
		    String username = (String) session.getAttribute("username");

		    // Load the existing patient information from the database
		    PatientInfo existingPatientInfo = patientInfoService.getPatientInfoById(patientnumber);

		    // Check if the patient information exists
		    if (existingPatientInfo != null) {
		        // Update the fields of the existing patient information
		        existingPatientInfo.setFirstname(firstname);
		        existingPatientInfo.setMiddlename(middlename);
		        existingPatientInfo.setLastname(lastname);
		        existingPatientInfo.setPatientage(patientage);
		        existingPatientInfo.setPatientgender(patientgender);
		        existingPatientInfo.setPatientregdate(patientregdate);
		        existingPatientInfo.setPatientmobile1(patientmobile1);
		        existingPatientInfo.setPatientmobile2(patientmobile2);
		        existingPatientInfo.setPatientmedicalhistory(patientmedicalhistory);
		        existingPatientInfo.setCashiername(username);

		        // Update the patientReports if a new file is provided
		        if (patientReports != null && !patientReports.isEmpty()) {
		            existingPatientInfo.setPatientReports(patientReports.getBytes());
		        }
		        // Save the updated patient information using the .save method
		        patientInfoRepository.save(existingPatientInfo);
		    }

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
		
		
		@GetMapping("/patients/excel")
		public void exportPatientsAndProceduresToExcel(HttpServletResponse response) throws IOException {
		    ByteArrayOutputStream excelData = patientInfoService.exportPatientsAndProceduresToExcel();
		    // Generate the file name with the current date
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		    String currentDate = dateFormat.format(new Date());
		    String fileName = "patient_and_procedure_" + currentDate + ".xlsx";
		    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		    excelData.writeTo(response.getOutputStream());
		    excelData.close();
		}

			
//PatientInfo Code Ends here----------------------------------------------------------------------------------------------
	

//PatientProcedure controller ------------------------------------------------------------------------------	

			 @GetMapping("/patientDetails/{patientId}")
			 public String showPatientDetail(HttpServletRequest request, @PathVariable("patientId") int patientId,Model model) {

					HttpSession session = request.getSession();
				     String username = (String) session.getAttribute("username");	
				     if (username != null) {
				         User user = userServiceImpl.findByUsername(username);

				         if (user != null) {
				             // Pass the user's role to the view
				             model.addAttribute("userRole", user.getRole());

				             // Pass the username to the view
				             model.addAttribute("username", username);
				             PatientInfo patientInfo = patientInfoService.getPatientInfoById(patientId);
				             model.addAttribute("patientinfo", patientInfo);

				             List<PatientProcedure> patientProcedures = patientProcedureService.getProceduresByPatientId(patientId);
				             model.addAttribute("patientProcedures", patientProcedures);
				             return "patientDetails";
				         }
				     }

				     // Handle the case where the user is null
				     model.addAttribute("error", "User not found.");
				     return "redirect:/login";

				     
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
		   public String savePatientProcedure(@ModelAttribute PatientProcedure patientProcedure,
				   @PathVariable("patientnumber") int patientNumber, HttpServletRequest request) {				   
		       HttpSession session = request.getSession(); // Get username from session
		       String username = (String) session.getAttribute("username");
		       PatientInfo patientInfo = patientInfoService.getPatientInfoById(patientNumber);	// Fetch patient information
		       patientProcedure.setCashiername(username); // Set proc_cashier_name and procedure number
		       patientProcedure.setProcedurenumber(patientInfo);
		       // Save patient procedure
		       patientProcedureService.savePatientProcedure(patientProcedure);
		       return "redirect:/patientList";
		   }
		   

		   @PostMapping("/UpdatePatientProcedure/{patientnumber}")
		   public String updatePatientProcedure(@ModelAttribute PatientProcedure patientProcedure, @PathVariable("patientnumber") int patientNumber, HttpServletRequest request) {
		       // Your controller logic here
			   HttpSession session = request.getSession(); // Get username from session
		       String username = (String) session.getAttribute("username");
		       PatientInfo patientInfo = patientInfoService.getPatientInfoById(patientNumber);	// Fetch patient information
		       patientProcedure.setCashiername(username); // Set proc_cashier_name and procedure number
		       patientProcedure.setProcedurenumber(patientInfo);
		       // Save patient procedure
		       patientProcedureService.savePatientProcedure(patientProcedure);
		       return "redirect:/patientDetails/" + patientNumber;
		   }

	
			
			@GetMapping("editProcedure/{patientId}/{procedureId}")
			public String editProcedureForm(HttpServletRequest request,@PathVariable(value = "patientId") int patientId,
					@PathVariable("procedureId") int procedureId, Model model) {
				HttpSession session = request.getSession();
			     String username = (String) session.getAttribute("username");
			     User user = userServiceImpl.findByUsername(username);
			     // Pass the username to the view
			     model.addAttribute("username", username); 	
			     model.addAttribute("userRole", user.getRole());
			    PatientProcedure patientProcedure = patientProcedureService.getPatientProcedureById(procedureId);
				model.addAttribute("patientProcedure", patientProcedure);
			    PatientInfo patientInfo = patientInfoService.getPatientInfoById(patientId);
			    model.addAttribute("patientinfo", patientInfo);
				return "editProcedure";
			}
			
		   @GetMapping("/deleteProcedure/{patientId}/{procedureId}")
		   public String deletePatientProcedure(@PathVariable(value = "patientId") int patientId,
				   @PathVariable(value = "procedureId") int procedureId) {
		       this.patientProcedureService.deletePatientProcedureById(procedureId);
		       return "forward:/patientDetails/" + patientId; // Use "forward" to stay on the same page
		   }

 
//PatientProcedure controller ENDs		
	

		   @GetMapping("/displayAmount")
		   public String showAmount(HttpServletRequest request, Model model) {
		       // Initialize fromDate and toDate with default values if needed
		       Date fromDate = null; // Set your default fromDate value here
		       Date toDate = null; // Set your default toDate value here

		       // Add fromDate and toDate to the model so they can be pre-populated in the form
		       HttpSession session = request.getSession();
			   String username = (String) session.getAttribute("username");
			   model.addAttribute("username", username); 	
		       model.addAttribute("fromDate", fromDate);
		       model.addAttribute("toDate", toDate);

		       return "displayAmount";
		   }

		   
		   @PostMapping("/filterData")
		    public String filterProcedures(
		            @RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
		            @RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
		            @RequestParam("session") String session, HttpServletRequest request,
		            Model model) {
			   
		        // Get filtered procedures based on dates and session
		        List<PatientProcedure> filteredProcedures = patientProcedureService.getFilteredProcedures(fromDate, toDate, session);
		        
		        HttpSession Session = request.getSession();
				String username = (String) Session.getAttribute("username");
				model.addAttribute("username", username); 
		        // Add the filtered procedures to the model for displaying in the view
		        model.addAttribute("patientProcedures", filteredProcedures);
		        // Add fromDate and toDate to the model for display in the view if needed
		        model.addAttribute("fromDate", fromDate);
		        model.addAttribute("toDate", toDate);
		        model.addAttribute("session", session);
		        return "displayAmount";
		    }




//Appointment controller--------------------------------------------------------------------------------------------------------		
		   
		   
		   @GetMapping("/appointment")
		   public String showAppointment(HttpServletRequest request, Model model) {
			   HttpSession Session = request.getSession();
				String username = (String) Session.getAttribute("username");
				model.addAttribute("username", username); 				
				Appointment appointment = new Appointment();
				model.addAttribute("appointment", appointment); 
				return "appointment";
		   }  
		   
		   @PostMapping("/saveAppointment")
		   public String saveAppointment(@RequestParam("starttime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date starttime,
		                                 @RequestParam("endtime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date endtime,
		                                 @RequestParam("firstname") String firstname,
		                                 @RequestParam("middlename") String middlename,
		                                 @RequestParam("lastname") String lastname,
		                                 @RequestParam("treatment") String treatment,
		                                 @RequestParam("patientmobile1") long patientmobile1,
		   								 HttpServletRequest request) {
		   HttpSession session = request.getSession(); // Get username from session
		   String username = (String) session.getAttribute("username");
		       appointmentService.saveAppointment(starttime, endtime, firstname, middlename, lastname, treatment, patientmobile1,username);            
		       return "redirect:/appointment";
		   }
		   
		   @PostMapping("/updateAppointment")
		   public String updateAppointment(@RequestParam("starttime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date starttime,
		                                 @RequestParam("endtime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date endtime,
		                                 @RequestParam("firstname") String firstname,
		                                 @RequestParam("middlename") String middlename,
		                                 @RequestParam("lastname") String lastname,
		                                 @RequestParam("treatment") String treatment,
		                                 @RequestParam("patientmobile1") long patientmobile1,
		                                 @RequestParam("appointmentnum") int appointmentnum) {
		       appointmentService.updateAppointment(starttime, endtime, firstname, middlename, lastname, treatment, patientmobile1,appointmentnum);            
		       return "redirect:/viewAppointment";
		   }
	
			@GetMapping("/editAppointment/{id}")
			public String editAppointment(@PathVariable("id") int id, Model model) {
				Appointment appointment = appointmentService.getAppointmentById(id);		    							
				model.addAttribute("appointment", appointment);						
				return "editAppointment";
			}
		   
			@GetMapping("/deleteAppointment/{id}")
			public String deleteAppointment(@PathVariable(value = "id") int id) {
				this.appointmentService.deleteAppointmentById(id);				
				return "redirect:/viewAppointment";
			}
		   
		   @GetMapping("/viewAppointment")
		   public String showAppointmentView(HttpServletRequest request, Model model) {
			   HttpSession Session = request.getSession();
				String username = (String) Session.getAttribute("username");
				User user = userServiceImpl.findByUsername(username);
			     model.addAttribute("userRole", user.getRole());
				model.addAttribute("username", username); 
				model.addAttribute("username", username); 			
				return "viewAppointment";
		   }
		   		   
		   @PostMapping("/filterAppointments")
		   public String filterAppointments(@RequestParam("appointmentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate, HttpServletRequest request, Model model) {
			   HttpSession Session = request.getSession();
				String username = (String) Session.getAttribute("username");
				User user = userServiceImpl.findByUsername(username);
			     
			     model.addAttribute("userRole", user.getRole());
				model.addAttribute("username", username); 
		       List<Appointment> filteredAppointments = appointmentService.getAppointmentsByDate(appointmentDate);
		       model.addAttribute("filteredAppointments", filteredAppointments);
		       model.addAttribute("selectedDate", appointmentDate);
		       return "viewAppointment";
		   }
		   		   
		   @GetMapping("/appointment/excel")
		    public void exportAppointmentsToExcel(HttpServletResponse response) throws IOException {
		        ByteArrayOutputStream excelData = appointmentService.exportAppointmentsToExcel();
		        // Generate the file name with the current date
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        String currentDate = dateFormat.format(new Date());
		        String fileName = "appointments_" + currentDate + ".xlsx";
		        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		        excelData.writeTo(response.getOutputStream());
		        excelData.close();
		    }
		   
}
