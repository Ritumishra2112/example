package com.apptad.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apptad.demo.model.Candidate;

@Repository
public class CandidateRepository {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public String insert(Candidate candidateModel) {
		String sql = "INSERT INTO Candidate(cname ,qualification , experience, skill, prevpack ,project ,emailid, contact) VALUES (:cname, :qualification ,:experience , :skill, :prevpack,:project,:emailid,:contact )";
		
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("cname",candidateModel.getCname());
		paramap.addValue("qualification", candidateModel.getQualification());
		
		paramap.addValue("experience", candidateModel.getExperience());
		paramap.addValue("skill", candidateModel.getSkill());
		paramap.addValue("prevpack", candidateModel.getPrevpack());
		paramap.addValue("project", candidateModel.getProject());
		paramap.addValue("emailid", candidateModel.getEmailid());
		paramap.addValue("contact", candidateModel.getContact());
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 
		if(i==1)
			 return "Record Inserted";
		 else
			 return "Record cannot be inserted";
	}

}
