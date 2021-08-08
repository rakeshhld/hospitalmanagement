package com.hospital.hospitalmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.hospitalmanagement.dao.Doctor;
import com.hospital.hospitalmanagement.dao.Login;
import com.hospital.hospitalmanagement.model.LoginBean;
import com.hospital.hospitalmanagement.model.RegisterBean;
import com.hospital.hospitalmanagement.repo.RegistrationRepo;
import com.hospital.hospitalmanagement.service.DoctorService;
import com.hospital.hospitalmanagement.service.LoginService;
import com.hospital.hospitalmanagement.service.PatientRegistrationService;

@Controller
public class FrontendController {
	
	@Autowired PatientRegistrationService patientservice;
	
	@Autowired LoginService loginService;
	
	@Autowired RegistrationRepo registerRepo;
	@Autowired DoctorService docService;
	
	@GetMapping("/login")
	public String loginPage(Model model){
		model.addAttribute("login", new LoginBean());
		System.out.println("in logg in =========================");
		return "login";
	}
	
	@GetMapping("/patient-home")
	public String patienthome(){
		System.out.println("in logg in =========================");
		return "Patient_home";
	}
	
	@PostMapping("/processlogin")
    public String submit(Model model,
            @ModelAttribute("loginBean") LoginBean loginBean) {
        if (loginBean != null && loginBean.getUserName() != null
                & loginBean.getPassword() != null) {
            if (loginService.processLogin(loginBean.getUserName(), loginBean.getPassword())) {
                model.addAttribute("msg", loginBean.getUserName());
                //check if registered as admin or patient
                Optional<Login> optionalUserDao = registerRepo.findByEmail(loginBean.getUserName());
                if(optionalUserDao.isPresent()) {
                	if(optionalUserDao.get().getRole().equals("admin")) {
                		return "Admin_home";
                	} else {
                		 return "Patient_home";
                	}
                } else {
                	 model.addAttribute("error", "Invalid Details");
                     return "error";
                }
            } else {
                model.addAttribute("error", "Invalid Details");
                return "error";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
	
	@GetMapping("/register")
	public String register(Model model){
		
		model.addAttribute("registerbean", new RegisterBean());
		System.out.println("in register =========================");
		return "Registration";
	}
	@PostMapping("/registerUser")
    public String registerUser(Model model,
            @ModelAttribute("registerbean") RegisterBean rb) {
		patientservice.Register(rb);
		/*if(status && !rb.getRole().equals("admin")){
			return "Patient_home";
		} else {
			return "Admin_home";
		}*/
		model.addAttribute("login", new LoginBean());
		return "login";
	}
	
	@GetMapping("/appointmentPage")
	public String appointment(Model model){
		
		//model.addAttribute("registerbean", new RegisterBean());
		System.out.println("in register =========================");
		return "appointment";
	}
	
	@GetMapping("/addDoctor")
	public String addDoctor() {
		return "Docter-add";
	}
	//add_patient
	@GetMapping("/addPatient")
	public String add_patient() {
		return "add_patient";
	}
	
	@GetMapping("/viewDoctor")
	public String viewDoctor() {
		return "viewDoctors";
	}
	@GetMapping("/viewPatient")
	public String viewPatient() {
		return "viewPatients";
	}
	
	@GetMapping("/viewAppointment")
	public String viewAppointment() {
		return "viewAppointment";
	}
	@GetMapping("/updateDoctor/{Id}")
	public String UpdateDoctor(@PathVariable("Id") String id,Model model) {
		int patientId = Integer.parseInt(id);
		Doctor doc =  docService.getDoctorByID(patientId);
		model.addAttribute("doc",doc);
		return "Docter-update";
	}

}
