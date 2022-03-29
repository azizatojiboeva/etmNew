package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;

public class Info{

	@SerializedName("website")
	private Object website;

	@SerializedName("name")
	private String name;

	@SerializedName("logo")
	private Object logo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("registerNumber")
	private String registerNumber;

	@SerializedName("paid_for")
	private String paidFor;

	@SerializedName("created_by")
	private Object createdBy;

	@SerializedName("status")
	private int status;

	public Object getWebsite(){
		return website;
	}

	public String getName(){
		return name;
	}

	public Object getLogo(){
		return logo;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public String getRegisterNumber(){
		return registerNumber;
	}

	public String getPaidFor(){
		return paidFor;
	}

	public Object getCreatedBy(){
		return createdBy;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Info{" + 
			"website = '" + website + '\'' + 
			",name = '" + name + '\'' + 
			",logo = '" + logo + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",registerNumber = '" + registerNumber + '\'' + 
			",paid_for = '" + paidFor + '\'' + 
			",created_by = '" + createdBy + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}