package com.codetest.springcodetest.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codetest.springcodetest.domain.ConfigCreateResponse;
import com.codetest.springcodetest.domain.GetConfigResponse;
import com.codetest.springcodetest.domain.GetVersionListResponse;
import com.codetest.springcodetest.exception.SpringCodeTestException;
import com.codetest.springcodetest.model.Config;
import com.codetest.springcodetest.repository.ConfigRepository;
import com.codetest.springcodetest.utils.CodeTestConstants;
import com.codetest.springcodetest.utils.CodeTestUtils;

/**
 * @author ANNIE
 *
 */
@Service
public class ConfigService {

	private final static transient Logger logger = LoggerFactory.getLogger(ConfigService.class);

	@Autowired
	ConfigRepository configRepository;

	/**
	 * Return JSON document for specified appCode and version.
	 * 
	 * @param appCode
	 * @param version
	 * @return GetConfigResponse
	 * @throws SpringCodeTestException
	 */
	public GetConfigResponse getConfig(String appCode, String version) throws SpringCodeTestException {
		logger.info("getConfig start()");
		Config config = null;
		try {
			config = configRepository.findByAppCodeAndVersion(appCode, version);
		} catch (SpringCodeTestException scte) {
			throw new SpringCodeTestException(scte.getMessage(),CodeTestConstants.ERROR_RETRIEVING_CONFIG, scte);
		}
		GetConfigResponse getConfigResponse = CodeTestUtils.JsonToObject(config.getConfigcreate());
		logger.info("getConfig end()");
		return getConfigResponse;
	}

	/**
	 * Return list of available versions in JSON sorted by last modified date in
	 * descending order.
	 * 
	 * @param appCode
	 * @return GetVersionListResponse
	 * @throws SpringCodeTestException
	 */
	public GetVersionListResponse getVersionList(String appCode) throws SpringCodeTestException {
		logger.info("getVersionList start()");
		GetVersionListResponse getVersionListResponse = new GetVersionListResponse();

		List<Config> configs = null;
		try {
			configs = configRepository.findByAppCodeOrderByUpdatedAtDesc(appCode);
		} catch (SpringCodeTestException scte) {
			throw new SpringCodeTestException(scte.getMessage(),CodeTestConstants.ERROR_RETRIEVING_VERSION_LIST, scte);
		}
		List<String> list = new ArrayList<String>();
		for (Config version : configs) {
			list.add(version.getVersion());
		}
		getVersionListResponse.setVersion(list);
		logger.info("getVersionList start()");
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
	 * @throws SpringCodeTestException
	 */
	public ConfigCreateResponse createConfig(Config config) throws SpringCodeTestException {
		logger.info("createConfig start()");
		Config c = new Config();
		try {
			c = configRepository.findByAppCodeAndVersion(c.getAppCode(), c.getVersion());
		} catch (SpringCodeTestException scte) {
			throw new SpringCodeTestException(scte.getMessage(), CodeTestConstants.ERROR_CREATING_CONFIG, scte);
		}
		if (c != null) {
			config.setId(c.getId());
		}
		configRepository.save(config);
		logger.info("createConfig start()");
		return new ConfigCreateResponse("SUCCESS");
	}
}
