package com.example.memberareainovindo.Model.response.login;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("date_birth")
	private String dateBirth;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("fullname")
	private String fullname;

	@SerializedName("gambar")
	private Object gambar;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private String status;

	public String getDateBirth(){
		return dateBirth;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public String getFullname(){
		return fullname;
	}

	public Object getGambar(){
		return gambar;
	}

	public String getEmail(){
		return email;
	}

	public String getStatus(){
		return status;
	}
}