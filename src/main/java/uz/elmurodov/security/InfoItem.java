package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;

public class InfoItem{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("code")
	private String code;

	@SerializedName("phone")
	private String phone;

	@SerializedName("language")
	private String language;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("username")
	private String username;

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"InfoItem{" + 
			"firstname = '" + firstname + '\'' + 
			",code = '" + code + '\'' + 
			",phone = '" + phone + '\'' + 
			",language = '" + language + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}