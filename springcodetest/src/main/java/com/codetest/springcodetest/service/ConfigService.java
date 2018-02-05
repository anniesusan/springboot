package com.codetest.springcodetest.service;

import com.codetest.springcodetest.domain.ConfigCreateResponse;
import com.codetest.springcodetest.domain.GetConfigResponse;
import com.codetest.springcodetest.domain.GetVersionListResponse;
import com.codetest.springcodetest.exception.SpringCodeTestException;
import com.codetest.springcodetest.model.Config;

public interface ConfigService {

	public GetConfigResponse getConfig(String appCode, String version) throws SpringCodeTestException;
	
	public GetVersionListResponse getVersionList(String appCode) throws SpringCodeTestException;
	
	public ConfigCreateResponse createConfig(Config config) throws SpringCodeTestException;
	
}
