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

import com.codetest.springcodetest.model.Config;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RepositoryTest {
 
   
    @Autowired
    private ConfigRepository configRepository;
    
	private Config config;

	@Before
	public void setUp() {
		config = new Config("33","44","4444", new Date(2018-02-02), new Date(2018-02-02));

	}
 
    @Test
    public void saveConfigTest() { 
    	configRepository.save(config);
    	Config retrivedConfig = configRepository.findByAppCodeAndVersion("33", "44"); 
         Assert.assertEquals(retrivedConfig.getVersion(), retrivedConfig.getVersion());
    }
 
}
