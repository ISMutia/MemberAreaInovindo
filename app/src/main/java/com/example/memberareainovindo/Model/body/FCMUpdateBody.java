package com.example.memberareainovindo.Model.body;

import com.google.gson.annotations.SerializedName;

public class FCMUpdateBody {

	@SerializedName("token_fcm")
	private String tokenFcm;

	public String getTokenFcm(){
		return tokenFcm;
	}

	public void setTokenFcm(String tokenFcm) {
		this.tokenFcm = tokenFcm;
	}
}