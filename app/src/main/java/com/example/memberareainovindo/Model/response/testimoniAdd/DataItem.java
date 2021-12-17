package com.example.memberareainovindo.Model.response.testimoniAdd;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("id_customers")
	private int idCustomers;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private String status;

	public int getIdCustomers(){
		return idCustomers;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getDescription(){
		return description;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public String getStatus(){
		return status;
	}
}