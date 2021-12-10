package com.example.memberareainovindo.Model.response.order;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("mulai_p")
	private String mulaiP;

	@SerializedName("selesai_p")
	private String selesaiP;

	@SerializedName("id_domain")
	private int idDomain;

	@SerializedName("lama_domain")
	private Object lamaDomain;

	@SerializedName("id_customers")
	private int idCustomers;

	@SerializedName("id_price")
	private int idPrice;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("project_name")
	private String projectName;

	@SerializedName("lama_p")
	private String lamaP;

	public String getMulaiP(){
		return mulaiP;
	}

	public String getSelesaiP(){
		return selesaiP;
	}

	public int getIdDomain(){
		return idDomain;
	}

	public Object getLamaDomain(){
		return lamaDomain;
	}

	public int getIdCustomers(){
		return idCustomers;
	}

	public int getIdPrice(){
		return idPrice;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public String getProjectName(){
		return projectName;
	}

	public String getLamaP(){
		return lamaP;
	}

	@Override
	public String toString() {
		return "DataItem{" +
				"mulaiP='" + mulaiP + '\'' +
				", selesaiP='" + selesaiP + '\'' +
				", idDomain=" + idDomain +
				", lamaDomain=" + lamaDomain +
				", idCustomers=" + idCustomers +
				", idPrice=" + idPrice +
				", updatedAt='" + updatedAt + '\'' +
				", createdAt=" + createdAt +
				", id=" + id +
				", projectName='" + projectName + '\'' +
				", lamaP='" + lamaP + '\'' +
				'}';
	}
}