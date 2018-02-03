package com.codetest.springcodetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codetest.springcodetest.model.Config;

public interface ConfigRepository extends CrudRepository<Config, Long> {

	public Config findByAppCodeAndVersion(String appCode, String version);

	public List<Config> findByAppCodeOrderByUpdatedAtDesc(String appCode);
    
	/*@Modifying
    @Query("UPDATE config c SET c.appCode = :appCode WHERE c.id = :id")
    public void updateConfig(@Param("appCode") String appCode, @Param("id") Long id);*/
}
