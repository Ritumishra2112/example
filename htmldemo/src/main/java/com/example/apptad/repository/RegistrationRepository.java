package com.example.apptad.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.apptad.model.Registration;

@Repository
public class RegistrationRepository {

@Autowired
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public String insert(Registration reg) {
String sql = "INSERT INTO Registration(name ,address,email,contact) VALUES (:name, :address ,:email , :contact)";
		
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("name", reg.getName());
		paramap.addValue("address", reg.getAddress());
		paramap.addValue("email", reg.getEmail());
		paramap.addValue("contact", reg.getContact());
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		if(i==1)
			return "Registration";
		else
			return "Not Inserted";
		
		
	}

}
