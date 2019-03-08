package com.tyyd.hadoop.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ConfigurationProperties(prefix = "druid")
public class OracleConf {
	private String username;
	private String password;
	private String url;
	private String driverClassName;
	private int initialSize;
	private int minIdle;
	private int maxActive;
	private int maxWait;
	private String validationQuery;
	
	
	@Bean(name = "oracleDs")
	public DataSource getDs(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName); 
		dataSource.setUsername(username); 
		dataSource.setPassword(password); 
		dataSource.setUrl(url); 
		dataSource.setInitialSize(initialSize); 
		dataSource.setMinIdle(minIdle); 
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxWait(maxWait);
		dataSource.setValidationQuery(validationQuery);
		return dataSource;
	}

	@Bean(name = "oracleJt")
	public JdbcTemplate getJt(@Qualifier("oracleDs") DataSource ds){
		return new JdbcTemplate(ds);
	}
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDriverClassName() {
		return driverClassName;
	}


	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}


	public int getInitialSize() {
		return initialSize;
	}


	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}


	public int getMinIdle() {
		return minIdle;
	}


	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}


	public int getMaxActive() {
		return maxActive;
	}


	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}


	public int getMaxWait() {
		return maxWait;
	}


	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}


	public String getValidationQuery() {
		return validationQuery;
	}


	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
}
