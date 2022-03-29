package uz.elmurodov.response;

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

	public void setWebsite(Object website){
		this.website = website;
	}

	public Object getWebsite(){
		return website;
	}

	public void setRegNum(String regNum){
		this.regNum = regNum;
	}

	public String getRegNum(){
		return regNum;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLogo(Object logo){
		this.logo = logo;
	}

	public Object getLogo(){
		return logo;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPaidFor(String paidFor){
		this.paidFor = paidFor;
	}

	public String getPaidFor(){
		return paidFor;
	}

	public void setEmail(Object email){
		this.email = email;
	}

	public Object getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Organization{" + 
			"website = '" + website + '\'' + 
			",reg_num = '" + regNum + '\'' + 
			",name = '" + name + '\'' + 
			",logo = '" + logo + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",paid_for = '" + paidFor + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}