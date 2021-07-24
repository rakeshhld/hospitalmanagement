package com.hospital.hospitalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.hospitalmanagement.model.LoginBean;
import com.hospital.hospitalmanagement.model.RegisterBean;
import com.hospital.hospitalmanagement.service.LoginService;
import com.hospital.hospitalmanagement.service.PatientRegistrationService;

@Controller
public class FrontendController {
	
	@Autowired PatientRegistrationService patientservice;
	
	@Autowired LoginService loginService;
	
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
                return "Patient_home";
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
		boolean status = patientservice.Register(rb);
		if(status){
			return "Patient_home";
		}
		model.addAttribute("login", new LoginBean());
		return "login";
	}
	
	@GetMapping("/appointmentPage")
	public String appointment(Model model){
		
		//model.addAttribute("registerbean", new RegisterBean());
		System.out.println("in register =========================");
		return "appointment";
	}
	

}
