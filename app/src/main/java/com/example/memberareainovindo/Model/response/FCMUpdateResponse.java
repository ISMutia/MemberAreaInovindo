package com.example.memberareainovindo.Model.response;

import com.google.gson.annotations.SerializedName;

public class FCMUpdateResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}