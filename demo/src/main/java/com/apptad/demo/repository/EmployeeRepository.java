package com.apptad.demo.repository;

import java.util.Collection;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.Map;

//import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.apptad.demo.model.Employee;

@Repository
public class EmployeeRepository {
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	
	//INSERT REPOSITORY
	public String insert(Employee employeeModel) {
		String sql = "INSERT INTO Employee(empId, fname ,lname , address, contact,emailId) VALUES (:empId, :fname ,:lname , :address, :contact,:emailId )";
		
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		System.out.println(employeeModel.getFname());
		
		paramap.addValue("lname",employeeModel.getLname());
		System.out.println(employeeModel.getLname());
		
		paramap.addValue("address",employeeModel.getAddress());
		paramap.addValue("contact",employeeModel.getContact());
		paramap.addValue("emailId",employeeModel.getEmailId());
		
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 
		if(i==1)
			 return "Record Inserted";
		 else
			 return "Record cannot be inserted";
	}
	

	
	
	//UPDATE REPOSITORY
	public String update(Employee employeeModel) {
		
		String sql = "UPDATE Employee SET fname=:fname where empId=:empId";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		
		if(i==1)
			 return "Record updated";
		 else
			 return "Record cannot be updated";
	}
	
	
	
	
	
	
	
	//DELETE REPOSITORY
	public String delete(Employee employeeModel) {
		
		String sql = "DELETE from Employee where empId=:empId and fname=:fname";
		
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 
		if(i==1)
			 return "Record deleted";
		 else
			 return "Record cannot be deleted";
	}
	
	
//	public Collection<Employee> search(String empId) {
//		
//		
////		MapSqlParameterSource paramap = new MapSqlParameterSource();
//		
////		int i=namedParameterJdbcTemplate.update(sql, paramap);
////		if(i==1)
//		
////		 if(i==1)
////			 return "Record searched";
////		 else
////			 return null;
//		
		
		
		
	
 
	
	
	//SEARCH REPOSITORY
	public Collection<Employee> search(String empId) {
		
		String sql ="SELECT *  FROM Employee WHERE empId=:empId";
		
		Map<String,Object> paramap=new HashMap<>();
		//SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(empId);
		
		paramap.put("empId",empId);
		
		return namedParameterJdbcTemplate.query(sql, paramap ,BeanPropertyRowMapper.newInstance(Employee.class));
	}




	public Collection<Employee> searchByName(String fname) {
		// TODO Auto-generated method stub
        String sql ="SELECT *  FROM Employee WHERE fname=:fname";
		
		Map<String,Object> paramap1=new HashMap<>();
		//SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(empId);
		
		paramap1.put("fname",fname);
		
		return namedParameterJdbcTemplate.query(sql, paramap1 ,BeanPropertyRowMapper.newInstance(Employee.class));
	}


	
	
 }

