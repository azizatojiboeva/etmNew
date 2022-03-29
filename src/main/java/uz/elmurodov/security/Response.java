package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response{

	@SerializedName("Response")
	private List<ResponseItem> response;

	public void setResponse(List<ResponseItem> response){
		this.response = response;
	}

	public List<ResponseItem> getResponse(){
		return response;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"response = '" + response + '\'' + 
			"}";
		}
}