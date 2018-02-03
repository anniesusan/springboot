package com.codetest.springcodetest.utils;

import com.codetest.springcodetest.domain.ConfigCreateRequest;
import com.codetest.springcodetest.model.Config;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CodeTestUtils {
	
    public static Config buildConfigEntity(String appCode, String version,ConfigCreateRequest csr){
   	 ObjectMapper mapper = new ObjectMapper();  
	        	Config config = new Config();
	        	config.setAppCode(appCode);
	        	config.setVersion(version);
	        	try {
					config.setConfigcreate(mapper.writeValueAsString(csr));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	return config;
   }

}
