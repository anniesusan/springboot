package com.codetest.springcodetest.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codetest.springcodetest.exception.SpringCodeTestException;
import com.codetest.springcodetest.model.Config;
import com.codetest.springcodetest.utils.CodeTestConstants;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RepositoryTest {

	@Autowired
	private ConfigRepository configRepository;

	private Config config;

	@Before
	public void setUp() {
		config = new Config("prod", "prodg", "profs", new Date(2018 - 02 - 02), new Date(2018 - 02 - 02));

	}

	@Test
	public void saveConfigTest() {

		Config c = new Config();

		try {
			c = configRepository.findByAppCodeAndVersion("prod", "prodg");
		} catch (SpringCodeTestException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (c != null) {
			config.setId(c.getId());
		}
		configRepository.save(config);
		Config retrivedConfig = null;

		try {
			retrivedConfig = configRepository.findByAppCodeAndVersion("prod", "prodg");
		} catch (SpringCodeTestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(retrivedConfig.getVersion(), "prodg");
	}

}
