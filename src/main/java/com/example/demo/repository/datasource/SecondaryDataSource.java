package com.example.demo.repository.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.secondary")
public class SecondaryDataSource {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Bean(name="secondDataSource")
	public DataSource createDataSource() {
		return DataSourceBuilder
				.create()
				.driverClassName(driverClassName)
				.url(url)
				.username(username)
				.password(password)
				.build();
	}
	
	@Bean(name="secondaryJdbc")
	public JdbcTemplate createSecondaryJdbcTemplate(@Qualifier("secondDataSource") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
