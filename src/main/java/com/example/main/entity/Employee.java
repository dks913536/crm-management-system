package com.example.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "register")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	@NotEmpty(message = "Name cannot be empty")
	@Pattern(regexp = "^[a-zA-Z ]{5,30}$",message = "Name is not valid")
	private String name;
	
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&*'_%+-/{|}?^]+@[a-zA-Z0-9.-]+(?:\\.[a-zA-Z0-9-]+)*$",message = "Email is not valid")
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{2,30}$",message = "Passord is not valid")
	private String password;
	
	@Pattern(regexp = "^[0-9]{10}$",message = "Phone No is not valid")
	private String phoneno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
}
