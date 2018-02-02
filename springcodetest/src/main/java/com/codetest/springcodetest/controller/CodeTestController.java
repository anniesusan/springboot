package com.codetest.springcodetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.springcodetest.domain.ConfigCreateRequest;
import com.codetest.springcodetest.domain.ConfigCreateResponse;


@RestController
@RequestMapping("/api")
public class CodeTestController {
	
	//@Autowired
	//ConfigRepository configService;

	@RequestMapping(value = "/config/{id}", method = RequestMethod.GET)
	public String getConfig(){
		return "hey";
		
		//return Arrays.asList(new Config("GetUsers", 12));
	}
	
    @PostMapping("/{appCode}/config/{version}")
    @ResponseBody
    public ResponseEntity<ConfigCreateResponse> createConfig(@PathVariable(value = "appCode") String appCode,@PathVariable(value = "version") String version,@RequestBody ConfigCreateRequest csr) {
    	ConfigCreateResponse configCreateResponse = new ConfigCreateResponse("Success");
         String env = csr.getEnv();
         
    	return ResponseEntity.ok().body(configCreateResponse);
        
        
    }
	
}
