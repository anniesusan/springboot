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
import com.codetest.springcodetest.service.ConfigService;
import com.codetest.springcodetest.utils.CodeTestUtils;

@RestController
@RequestMapping("/api")
public class CodeTestController {

	@Autowired
	ConfigService configService;

	@RequestMapping(value = "/config/{id}", method = RequestMethod.GET)
	public String getConfig() {
		return "hey";

		// return Arrays.asList(new Config("GetUsers", 12));
	}

	/**
	 * @param appCode
	 * @param version
	 * @param csr
	 * @return ConfigCreateResponse
	 */
	@PostMapping("/{appCode}/config/{version}")
	@ResponseBody
	public ResponseEntity<ConfigCreateResponse> createConfig(@PathVariable(value = "appCode") String appCode,
			@PathVariable(value = "version") String version, @RequestBody ConfigCreateRequest csr) {
		ConfigCreateResponse configCreateResponse = null;
		configCreateResponse = configService.createConfig(CodeTestUtils.buildConfigEntity(appCode, version, csr));
		return ResponseEntity.ok().body(configCreateResponse);
	}

}
