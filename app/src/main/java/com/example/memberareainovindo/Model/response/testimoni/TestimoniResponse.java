package com.example.memberareainovindo.Model.response.testimoni;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TestimoniResponse{

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
}