package com.codetest.springcodetest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codetest.springcodetest.domain.ConfigCreateResponse;
import com.codetest.springcodetest.model.Config;
import com.codetest.springcodetest.repository.ConfigRepository;

@Service
public class ConfigService {

	@Autowired
	ConfigRepository configRepository;
	
	
public List<Config> getAllConfigs(String appCode){
	List<Config> configs=configRepository.findByAppCodeOrderByUpdatedAtDesc(appCode);
	
	/*List list=new ArrayList();
	for(Config version:configs){
		list.add(version.getVersion());
	}*/
		return configs;
		
	}
	
	public Config getConfig(String appCode,String version){
		
		return configRepository.findByAppCodeAndVersion(appCode,version);
	}
	
public ConfigCreateResponse createConfig(Config config){
	Config config1 = new Config();
	config1 = configRepository.findByAppCodeAndVersion(config.getAppCode(), config.getVersion());
	if(config1 != null) {
		config.setId(config1.getId());
	}
		configRepository.save(config);
		return new ConfigCreateResponse("SUCCESS");
	}
}


