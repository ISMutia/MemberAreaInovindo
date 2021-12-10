package com.example.memberareainovindo.Model.response.order;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private String status;

	public List<DataItem> getData(){
		return data;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "OrderResponse{" +
				"data=" + data +
				", status='" + status + '\'' +
				'}';
	}
}