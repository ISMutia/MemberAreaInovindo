package com.example.memberareainovindo.Model.response.orderAdd;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("link_group_wa")
	private String linkGroupWa;

	@SerializedName("id_domain")
	private int idDomain;

	@SerializedName("id_price")
	private int idPrice;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("project_name")
	private String projectName;

	@SerializedName("name_domain")
	private String nameDomain;

	@SerializedName("lama_p")
	private String lamaP;

	@SerializedName("mulai_p")
	private String mulaiP;

	@SerializedName("selesai_p")
	private String selesaiP;

	@SerializedName("lama_domain")
	private String lamaDomain;

	@SerializedName("id_customers")
	private int idCustomers;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id")
	private int id;

	public String getLinkGroupWa(){
		return linkGroupWa;
	}

	public int getIdDomain(){
		return idDomain;
	}

	public int getIdPrice(){
		return idPrice;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public String getProjectName(){
		return projectName;
	}

	public String getNameDomain(){
		return nameDomain;
	}

	public String getLamaP(){
		return lamaP;
	}

	public String getMulaiP(){
		return mulaiP;
	}

	public String getSelesaiP(){
		return selesaiP;
	}

	public String getLamaDomain(){
		return lamaDomain;
	}

	public int getIdCustomers(){
		return idCustomers;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getId(){
		return id;
	}
}