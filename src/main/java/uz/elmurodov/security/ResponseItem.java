package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;

public class ResponseItem{

	@SerializedName("code")
	private String code;

	@SerializedName("tz")
	private String tz;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("created_by")
	private int createdBy;

	@SerializedName("is_deleted")
	private boolean isDeleted;

	@SerializedName("is_archived")
	private boolean isArchived;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("background")
	private String background;

	@SerializedName("organization_id")
	private int organizationId;

	@SerializedName("name")
	private String name;

	@SerializedName("updated_by")
	private Object updatedBy;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private int status;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setTz(String tz){
		this.tz = tz;
	}

	public String getTz(){
		return tz;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setCreatedBy(int createdBy){
		this.createdBy = createdBy;
	}

	public int getCreatedBy(){
		return createdBy;
	}

	public void setIsDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}

	public boolean isIsDeleted(){
		return isDeleted;
	}

	public void setIsArchived(boolean isArchived){
		this.isArchived = isArchived;
	}

	public boolean isIsArchived(){
		return isArchived;
	}

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public void setBackground(String background){
		this.background = background;
	}

	public String getBackground(){
		return background;
	}

	public void setOrganizationId(int organizationId){
		this.organizationId = organizationId;
	}

	public int getOrganizationId(){
		return organizationId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUpdatedBy(Object updatedBy){
		this.updatedBy = updatedBy;
	}

	public Object getUpdatedBy(){
		return updatedBy;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseItem{" + 
			"code = '" + code + '\'' + 
			",tz = '" + tz + '\'' + 
			",description = '" + description + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",created_by = '" + createdBy + '\'' + 
			",is_deleted = '" + isDeleted + '\'' + 
			",is_archived = '" + isArchived + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",background = '" + background + '\'' + 
			",organization_id = '" + organizationId + '\'' + 
			",name = '" + name + '\'' + 
			",updated_by = '" + updatedBy + '\'' + 
			",id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}