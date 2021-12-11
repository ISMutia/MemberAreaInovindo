package com.example.memberareainovindo.Model.response.testimoniAdd;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestimoniAddResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public List<DataItem> getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "TestimoniAddResponse{" +
				"data=" + data +
				", message='" + message + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}