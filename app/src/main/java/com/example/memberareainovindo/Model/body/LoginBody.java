package com.example.memberareainovindo.Model.body;

import com.google.gson.annotations.SerializedName;

public class LoginBody{

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	public String getPassword(){
		return password;
	}

	public String getEmail(){
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}