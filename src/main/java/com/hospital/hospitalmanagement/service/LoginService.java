package com.hospital.hospitalmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalmanagement.dao.Login;
import com.hospital.hospitalmanagement.repo.RegistrationRepo;

@Service
public class LoginService {
	
	@Autowired RegistrationRepo registerRepo;
	
	public boolean processLogin(String email,String password) {
		Optional<Login> optionalLogin = registerRepo.findByEmail(email);
		if(optionalLogin.isPresent() ){
			Login obj = optionalLogin.get();
			if(obj.getPassword().equals(password) && obj.getEmail().equals(email)){
				return true;
			}
			return false;
		}
	
		return false;
	}

	
}
