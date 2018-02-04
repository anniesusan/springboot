package com.codetest.springcodetest.utils;

import java.io.IOException;

import com.codetest.springcodetest.domain.ConfigCreateRequest;
import com.codetest.springcodetest.domain.GetConfigResponse;
import com.codetest.springcodetest.model.Config;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author ANNIE
 *
 */
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
    
    public static GetConfigResponse JsonToObject (String json) {
            ObjectMapper mapper = new ObjectMapper();
            GetConfigResponse getConfigResponse= null;
            try {

            	getConfigResponse = mapper.readValue(json, GetConfigResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
			return getConfigResponse;
        }

}
