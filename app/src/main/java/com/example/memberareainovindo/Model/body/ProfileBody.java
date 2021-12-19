package com.example.memberareainovindo.Model.body;

import com.google.gson.annotations.SerializedName;

public class ProfileBody{

	@SerializedName("date_birth")
	private String dateBirth;

	@SerializedName("password")
	private String password;

	@SerializedName("address")
	private String address;

	@SerializedName("fullname")
	private String fullname;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private String status;

	@SerializedName("contact_wa")
	private String contactWa;

	public String getDateBirth(){
		return dateBirth;
	}

	public String getPassword(){
		return password;
	}

	public String getAddress(){
		return address;
	}

	public String getFullname(){
		return fullname;
	}

	public String getEmail(){
		return email;
	}

	public String getStatus(){
		return status;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setContactWa(String contactWa) {
		this.contactWa = contactWa;
	}

	public String getContactWa(){
		return contactWa;
	}
}