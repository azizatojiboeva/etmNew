package uz.elmurodov.security;

import 	java.util.List;
import com.google.gson.annotations.SerializedName;

public class SessionUser{

	@SerializedName("code")
	private String code;

	@SerializedName("is_super_user")
	private boolean isSuperUser;

	@SerializedName("roles")
	private List<RolesItem> roles;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("language")
	private String language;

	@SerializedName("phone")
	private String phone;

	@SerializedName("permissions")
	private List<PermissionsItem> permissions;

	@SerializedName("organization")
	private Organization organization;

	@SerializedName("id")
	private int id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public String getCode(){
		return code;
	}

	public boolean isIsSuperUser(){
		return isSuperUser;
	}

	public List<RolesItem> getRoles(){
		return roles;
	}

	public String getLastName(){
		return lastName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getLanguage(){
		return language;
	}

	public String getPhone(){
		return phone;
	}

	public List<PermissionsItem> getPermissions(){
		return permissions;
	}

	public Organization getOrganization(){
		return organization;
	}

	public int getId(){
		return id;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}
}