package com.example.memberareainovindo.Model.response.orderAdd;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OrderAddResponse{

	@SerializedName("data")
	private DataItem data;

	@SerializedName("id")
	private int id;

	@SerializedName("id_bill")
	private int id_bill;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public DataItem getData(){
		return data;
	}

	public int getId(){
		return id;
	}

	public int getId_bill() {
		return id_bill;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}