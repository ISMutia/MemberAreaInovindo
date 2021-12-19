package com.example.memberareainovindo.Model.response.billDetail;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("id_status")
	private int idStatus;

	@SerializedName("no_bill")
	private int noBill;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("bukti")
	private String bukti;

	@SerializedName("price_name")
	private String priceName;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("fullname")
	private String fullname;

	@SerializedName("id_h_orders")
	private int idHOrders;

	@SerializedName("project_name")
	private String projectName;

	@SerializedName("total_bayar")
	private int totalBayar;

	@SerializedName("name_domain")
	private String nameDomain;

	public int getNoBill(){
		return noBill;
	}

	public int getIdStatus(){
		return idStatus;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getBukti(){
		return bukti;
	}

	public String getPriceName(){
		return priceName;
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

	public int getIdHOrders(){
		return idHOrders;
	}

	public String getProjectName(){
		return projectName;
	}

	public int getTotalBayar(){
		return totalBayar;
	}

	public String getNameDomain(){
		return nameDomain;
	}

	@Override
	public String toString() {
		return "DataItem{" +
				"idStatus=" + idStatus +
				", updatedAt='" + updatedAt + '\'' +
				", bukti='" + bukti + '\'' +
				", priceName='" + priceName + '\'' +
				", createdAt=" + createdAt +
				", id=" + id +
				", fullname='" + fullname + '\'' +
				", idHOrders=" + idHOrders +
				", projectName='" + projectName + '\'' +
				", totalBayar=" + totalBayar +
				", nameDomain='" + nameDomain + '\'' +
				'}';
	}
}