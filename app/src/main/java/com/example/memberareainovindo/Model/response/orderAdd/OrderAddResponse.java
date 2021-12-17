package com.example.memberareainovindo.Model.response.orderAdd;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OrderAddResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("id")
	private int id;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public List<DataItem> getData(){
		return data;
	}

	public int getId(){
		return id;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}