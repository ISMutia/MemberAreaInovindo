package com.example.memberareainovindo.Model.response.orderAdd;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FormResponse{

	@SerializedName("price")
	private List<PriceItem> price;

	@SerializedName("domain")
	private List<DomainItem> domain;

	@SerializedName("status")
	private String status;

	public List<PriceItem> getPrice(){
		return price;
	}

	public List<DomainItem> getDomain(){
		return domain;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "FormResponse{" +
				"price=" + price +
				", domain=" + domain +
				", status='" + status + '\'' +
				'}';
	}
}