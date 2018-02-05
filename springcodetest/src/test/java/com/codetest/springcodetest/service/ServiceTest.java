package com.codetest.springcodetest.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.codetest.springcodetest.domain.ConfigCreateResponse;
import com.codetest.springcodetest.domain.GetConfigResponse;
import com.codetest.springcodetest.exception.SpringCodeTestException;
import com.codetest.springcodetest.model.Config;
import com.codetest.springcodetest.repository.ConfigRepository;
import com.codetest.springcodetest.utils.CodeTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	@Mock
	private static ConfigRepository configRepository;

	@InjectMocks
	private static ConfigService configService = new ConfigService();

	private Config config;

	@Test
	public void GetConfig() {

		Long accountId = 1001L;
		config = new Config();
		config.setId(accountId);
		config.setAppCode("22");
		config.setVersion("abc");
		config.setConfigcreate("{\"env\":\"hello\",\"endPoint\":\"eugin\",\"port\":\"eugin\"}");
		config.setCreatedAt(new Date(2018 - 02 - 02));
		config.setUpdatedAt(new Date(2018 - 02 - 02));

		GetConfigResponse retrivedConfig = null;
		try {
			Mockito.when(configRepository.findByAppCodeAndVersion("333", "555")).thenReturn(config);
			retrivedConfig = configService.getConfig("333", "555");
		} catch (SpringCodeTestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GetConfigResponse configObj = CodeTestUtils.JsonToObject(config.getConfigcreate());

		Assert.assertEquals(configObj.getEnv(), retrivedConfig.getEnv());

	}
	@Test
	public void CreateConfig() {

		Long accountId = 1001L;
		config = new Config();
		config.setId(accountId);
		config.setAppCode("22");
		config.setVersion("abc");
		config.setConfigcreate("{\"env\":\"hello\",\"endPoint\":\"eugin\",\"port\":\"eugin\"}");
		config.setCreatedAt(new Date(2018 - 02 - 02));
		config.setUpdatedAt(new Date(2018 - 02 - 02));

		ConfigCreateResponse csr = null;
		try {
			Mockito.when(configRepository.save(config)).thenReturn(config);
			csr = configService.createConfig(config);
			csr.getResponseStatus();
			Assert.assertEquals(csr.getResponseStatus(),"SUCCESS");
		} catch (SpringCodeTestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
