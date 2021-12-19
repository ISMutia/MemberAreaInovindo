package com.example.memberareainovindo.Model.response.profile;

import com.example.memberareainovindo.Model.response.login.Data;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	@SerializedName("data")
	private Data data;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}

	public Data getData() {
		return data;
	}

	@Override
	public String toString() {
		return "ProfileResponse{" +
				"message='" + message + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}