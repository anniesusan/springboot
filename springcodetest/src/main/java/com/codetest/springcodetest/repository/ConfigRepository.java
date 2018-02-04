package com.codetest.springcodetest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codetest.springcodetest.exception.SpringCodeTestException;
import com.codetest.springcodetest.model.Config;

public interface ConfigRepository extends CrudRepository<Config, Long> {

	public Config findByAppCodeAndVersion(String appCode, String version)throws SpringCodeTestException;

	public List<Config> findByAppCodeOrderByUpdatedAtDesc(String appCode) throws SpringCodeTestException;

}
