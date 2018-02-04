package com.codetest.springcodetest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.springcodetest.domain.ConfigCreateRequest;
import com.codetest.springcodetest.domain.ConfigCreateResponse;
import com.codetest.springcodetest.domain.GetConfigResponse;
import com.codetest.springcodetest.domain.GetVersionListResponse;
import com.codetest.springcodetest.exception.SpringCodeTestException;
import com.codetest.springcodetest.service.ConfigService;
import com.codetest.springcodetest.utils.CodeTestUtils;

/**
 * @author ANNIE
 *
 */
@RestController
@RequestMapping("/api")
public class CodeTestController extends BaseController {
	
	private final static transient Logger logger = LoggerFactory.getLogger(CodeTestController.class);

	@Autowired
	ConfigService configService;

	/**
	 * Return JSON document for specified appCode and version.
	 * 
	 * @param appCode
	 * @param version
	 * @return GetConfigResponse
	 */
	@GetMapping("/{appCode}/config/{version}")
	public ResponseEntity<GetConfigResponse> getConfig(@PathVariable(value = "appCode") String appCode,
			@PathVariable(value = "version") String version) throws SpringCodeTestException {
		logger.info("getConfig start()");
		GetConfigResponse getConfigResponse = configService.getConfig(appCode, version);
		logger.info("getConfig end()");
		return ResponseEntity.ok().body(getConfigResponse);

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
	@PostMapping("/{appCode}/config/{version}")
	@ResponseBody
	public ResponseEntity<ConfigCreateResponse> createConfig(@PathVariable(value = "appCode") String appCode,
			@PathVariable(value = "version") String version, @RequestBody ConfigCreateRequest csr) throws SpringCodeTestException {
		ConfigCreateResponse configCreateResponse = configService
				.createConfig(CodeTestUtils.buildConfigEntity(appCode, version, csr));
		return ResponseEntity.ok().body(configCreateResponse);
	}

	/**
	 * Return list of available versions in JSON sorted by last modified date in
	 * descending order.
	 * 
	 * @param appCode
	 * @return GetVersionListResponse
	 */
	@GetMapping("/{appCode}/config")
	public ResponseEntity<GetVersionListResponse> getVersionList(@PathVariable(value = "appCode") String appCode) throws SpringCodeTestException{
		GetVersionListResponse getVersionListResponse = configService.getVersionList(appCode);
		return ResponseEntity.ok().body(getVersionListResponse);

	}

}
