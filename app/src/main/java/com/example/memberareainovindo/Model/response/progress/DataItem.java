package com.example.memberareainovindo.Model.response.progress;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("progress")
	private int progress;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("id_h_orders")
	private int idHOrders;

	@SerializedName("project_name")
	private String projectName;

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public int getProgress(){
		return progress;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public int getIdHOrders(){
		return idHOrders;
	}

	public String getProjectName(){
		return projectName;
	}
}