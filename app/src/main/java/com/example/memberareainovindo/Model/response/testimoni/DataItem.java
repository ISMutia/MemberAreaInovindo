package com.example.memberareainovindo.Model.response.testimoni;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("id_customers")
	private int idCustomers;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("fullname")
	private String fullname;

	public int getIdCustomers(){
		return idCustomers;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public String getDescription(){
		return description;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public String getFullname(){
		return fullname;
	}

	@Override
	public String toString() {
		return "DataItem{" +
				"idCustomers=" + idCustomers +
				", updatedAt=" + updatedAt +
				", description='" + description + '\'' +
				", createdAt=" + createdAt +
				", id=" + id +
				", fullname='" + fullname + '\'' +
				'}';
	}
}