package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;

public class Organization{

	@SerializedName("website")
	private Object website;

	@SerializedName("reg_num")
	private String regNum;

	@SerializedName("name")
	private String name;

	@SerializedName("logo")
	private Object logo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("location")
	private String location;

	@SerializedName("id")
	private int id;

	@SerializedName("paid_for")
	private String paidFor;

	@SerializedName("email")
	private Object email;

	public Object getWebsite(){
		return website;
	}

	public String getRegNum(){
		return regNum;
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

	public String getLocation(){
		return location;
	}

	public int getId(){
		return id;
	}

	public String getPaidFor(){
		return paidFor;
	}

	public Object getEmail(){
		return email;
	}
}