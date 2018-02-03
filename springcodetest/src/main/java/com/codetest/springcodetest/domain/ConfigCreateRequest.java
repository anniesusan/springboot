/**
 * 
 */
package com.codetest.springcodetest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author anniesusan
 *
 */
@JsonIgnoreProperties(ignoreUnknown =true)
public class ConfigCreateRequest {
	
	private String env;
	private String endPoint;
	private String port;
	
	public ConfigCreateRequest(){
		
	}
	
	public ConfigCreateRequest(String env, String endPoint, String port) {
		super();
		this.env = env;
		this.endPoint = endPoint;
		this.port = port;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	
	
	

}
