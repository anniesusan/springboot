/**
 * 
 */
package com.codetest.springcodetest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ANNIE
 *
 */
@JsonIgnoreProperties(ignoreUnknown =true)
public class ConfigCreateResponse {
	

	private String responseStatus;
	
	public ConfigCreateResponse(){
		
	}

	public ConfigCreateResponse(String responseStatus) {
		super();
		this.responseStatus = responseStatus;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
}
