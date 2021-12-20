package com.example.memberareainovindo.Model.response.notification;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("id_customers")
	private int idCustomers;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("id_h_orders")
	private Object idHOrders;

	@SerializedName("tittle")
	private String tittle;

	public int getIdCustomers(){
		return idCustomers;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public Object getIdHOrders(){
		return idHOrders;
	}

	public String getTittle(){
		return tittle;
	}
}