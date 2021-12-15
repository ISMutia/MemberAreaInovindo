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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}