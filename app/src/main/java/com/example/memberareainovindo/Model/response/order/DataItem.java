package com.example.memberareainovindo.Model.response.order;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("id_domain")
	private int idDomain;

	@SerializedName("id_price")
	private int idPrice;

	@SerializedName("status_name")
	private String statusName;

	@SerializedName("price_name")
	private String priceName;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("project_name")
	private String projectName;

	@SerializedName("lama_p")
	private String lamaP;

	@SerializedName("mulai_p")
	private String mulaiP;

	@SerializedName("selesai_p")
	private String selesaiP;

	@SerializedName("lama_domain")
	private String lamaDomain;

	@SerializedName("domain_name")
	private String domainName;

	@SerializedName("id_customers")
	private int idCustomers;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("id")
	private int id;

	@SerializedName("fullname")
	private String fullname;

	public int getIdDomain(){
		return idDomain;
	}

	public int getIdPrice(){
		return idPrice;
	}

	public String getStatusName(){
		return statusName;
	}

	public String getPriceName(){
		return priceName;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public String getProjectName(){
		return projectName;
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

	public String getDomainName(){
		return domainName;
	}

	public int getIdCustomers(){
		return idCustomers;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public int getId(){
		return id;
	}

	public String getFullname(){
		return fullname;
	}
}