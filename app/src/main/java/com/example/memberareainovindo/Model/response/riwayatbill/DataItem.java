package com.example.memberareainovindo.Model.response.riwayatbill;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("id_status")
	private int idStatus;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("bukti")
	private Object bukti;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("id_h_orders")
	private int idHOrders;

	@SerializedName("total_bayar")
	private int totalBayar;

	public int getIdStatus(){
		return idStatus;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public Object getBukti(){
		return bukti;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public int getIdHOrders(){
		return idHOrders;
	}

	public int getTotalBayar(){
		return totalBayar;
	}
}