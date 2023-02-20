package com.example.apptad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.apptad.model.Registration;
import com.example.apptad.service.RegistrationService;

@Controller
public class HtmlDemoController {

@GetMapping(value="/")	
public String Registration() {
	return "Registration";
}
	
	
	
@Autowired	
RegistrationService irs;
@PostMapping(value="/register")

public String userRTegistration(@ModelAttribute Registration reg) {
	System.out.println(reg.toString());
	return irs.insert(reg);
}
}
