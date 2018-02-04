package com.codetest.springcodetest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetest.springcodetest.domain.ConfigCreateResponse;
import com.codetest.springcodetest.domain.GetConfigResponse;
import com.codetest.springcodetest.domain.GetVersionListResponse;
import com.codetest.springcodetest.model.Config;
import com.codetest.springcodetest.repository.ConfigRepository;
import com.codetest.springcodetest.utils.CodeTestUtils;

/**
 * @author ANNIE
 *
 */
@Service
public class ConfigService {

	@Autowired
	ConfigRepository configRepository;

	/**
	 * Return JSON document for specified appCode and version.
	 * 
	 * @param appCode
	 * @param version
	 * @return GetConfigResponse
	 */
	public GetConfigResponse getConfig(String appCode, String version) {
		Config config = configRepository.findByAppCodeAndVersion(appCode, version);
		GetConfigResponse getConfigResponse = CodeTestUtils.JsonToObject(config.getConfigcreate());
		return getConfigResponse;
	}
	
	/**
	 * Return list of available versions in JSON sorted by last modified date in descending order.
	 * 
	 * @param appCode
	 * @return GetVersionListResponse
	 */
	public GetVersionListResponse getVersionList(String appCode){
		GetVersionListResponse getVersionListResponse=new GetVersionListResponse();
		
		List<Config> configs = configRepository.findByAppCodeOrderByUpdatedAtDesc(appCode);
		 List<String> list=new ArrayList<String>(); 
		 for(Config version:configs){
		 list.add(version.getVersion()); 
		 }
		 getVersionListResponse.setVersion(list);
		return getVersionListResponse;
		
	}
	/**
	 * Add new or update existing JSON document for specified appCode and
	 * version. JSON document is captured from the Request Body.
	 * 
	 * @param appCode
	 * @param version
	 * @param ConfigCreateRequest
	 * @return ConfigCreateResponse
	 */
	public ConfigCreateResponse createConfig(Config config) {
		Config config1 = new Config();
		config1 = configRepository.findByAppCodeAndVersion(config.getAppCode(), config.getVersion());
		if (config1 != null) {
			config.setId(config1.getId());
		}
		configRepository.save(config);
		return new ConfigCreateResponse("SUCCESS");
	}
}
