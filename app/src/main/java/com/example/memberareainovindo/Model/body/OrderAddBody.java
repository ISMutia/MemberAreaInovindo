package com.example.memberareainovindo.Model.body;

import com.google.gson.annotations.SerializedName;

public class OrderAddBody{

	@SerializedName("mulai_p")
	private String mulaiP;

	@SerializedName("selesai_p")
	private String selesaiP;

	@SerializedName("lama_domain")
	private String lamaDomain;

	@SerializedName("id_domain")
	private String idDomain;

	@SerializedName("id_price")
	private String idPrice;

	@SerializedName("id_customers")
	private String idCustomers;

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

	public String getLamaDomain(){
		return lamaDomain;
	}

	public String getIdDomain(){
		return idDomain;
	}

	public String getIdPrice(){
		return idPrice;
	}

	public String getIdCustomers(){
		return idCustomers;
	}

	public String getProjectName(){
		return projectName;
	}

	public String getLamaP(){
		return lamaP;
	}
}