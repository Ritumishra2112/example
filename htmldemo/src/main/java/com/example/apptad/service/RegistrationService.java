package com.example.apptad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apptad.model.Registration;
import com.example.apptad.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	RegistrationRepository rr;
	public String insert(Registration reg) {
		// TODO Auto-generated method stub
		
		return rr.insert(reg);
	}

}
