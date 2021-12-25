package com.example.memberareainovindo.Model.response.register;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("data")
	private Object data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	@SerializedName("errors")
	private String errors;

	public Object getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}

	public String getErrors(){
		return errors;
	}

	@Override
	public String toString() {
		return "RegisterResponse{" +
				"data=" + data +
				", message='" + message + '\'' +
				", status='" + status + '\'' +
				", errors='" + errors + '\'' +
				'}';
	}
}