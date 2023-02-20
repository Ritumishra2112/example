package com.example.apptad.model;

public class Registration {

	private int id;
	private String name;
	private String address;
	private String email;
	private String contact;
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	

	public String getContact() {
		return contact;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String toString() {
		return this.id+" "+this.name+" "+this.email+" "+this.address+" "+this.contact;
	}
	
	
}
