package com.example.memberareainovindo.Model.response.orderForm;

import com.google.gson.annotations.SerializedName;

public class PriceItem{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	@Override
	public String toString() {
		return name;
	}
}