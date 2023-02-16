package com.apptad.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptad.demo.model.Employee;
import com.apptad.demo.repository.EmployeeRepository;
@Service
public class SearchService {
     @Autowired
	EmployeeRepository employeeRepository;
	public Collection<Employee> Search(String empId) {
		
		return employeeRepository.search(empId)	;
	}
	
	

      




	public Collection<Employee> SearchByName(String fname) {
		// TODO Auto-generated method stub
		return employeeRepository.searchByName(fname)	;
	}
}

