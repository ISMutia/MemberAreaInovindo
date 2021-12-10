package com.example.memberareainovindo.Model.body;

import com.google.gson.annotations.SerializedName;

public class RegisterBody{

	@SerializedName("date_birth")
	private String dateBirth;

	@SerializedName("password")
	private String password;

	@SerializedName("fullname")
	private String fullname;

	@SerializedName("email")
	private String email;

	public String getDateBirth(){
		return dateBirth;
	}

	public String getPassword(){
		return password;
	}

	public String getFullname(){
		return fullname;
	}

	public String getEmail(){
		return email;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}