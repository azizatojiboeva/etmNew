package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;

public class MembersItem{

	@SerializedName("userinfo")
	private Userinfo userinfo;

	@SerializedName("memberid")
	private int memberid;

	public Userinfo getUserinfo(){
		return userinfo;
	}

	public int getMemberid(){
		return memberid;
	}
}