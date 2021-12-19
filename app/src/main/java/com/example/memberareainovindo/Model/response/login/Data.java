package com.example.memberareainovindo.Model.response.login;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("date_birth")
	private String dateBirth;

	@SerializedName("address")
	private String address;

	@SerializedName("updated_at")
	private Object updatedAt;

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

	@SerializedName("contact_wa")
	private String contactWa;

	@SerializedName("gambar_url")
	private String gambar_url;

	public String getGambar_url() {
		return gambar_url;
	}

	public void setGambar_url(String gambar_url) {
		this.gambar_url = gambar_url;
	}


	public String getDateBirth(){
		return dateBirth;
	}

	public String getAddress(){
		return address;
	}

	public Object getUpdatedAt(){
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

	public String getContactWa(){
		return contactWa;
	}
}