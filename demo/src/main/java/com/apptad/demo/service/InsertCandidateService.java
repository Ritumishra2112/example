package com.apptad.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptad.demo.model.Candidate;
import com.apptad.demo.repository.CandidateRepository;

@Service
public class InsertCandidateService {
	@Autowired
	CandidateRepository candidateRepository;
	public String Insert(Candidate candidateModel) {
		
		return candidateRepository.insert(candidateModel);
	}

}
