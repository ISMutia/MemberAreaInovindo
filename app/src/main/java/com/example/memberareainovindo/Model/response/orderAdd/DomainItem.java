package com.example.memberareainovindo.Model.response.orderAdd;

import com.google.gson.annotations.SerializedName;

public class DomainItem{

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
		return "DomainItem{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}