package com.example.demo.repository.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.primary")
public class PrimaryDataSource {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	// @Beanアノテーションのname引数に指定する名前は、クラス名と別名を指定すること。そうしないとアプリケーションサーバ（Tomcat等)の起動時にエラーが発生する。
	@Bean(name="primDataSource")
	@Primary
	public DataSource createDataSource() {
		return DataSourceBuilder
				.create()
				.driverClassName(driverClassName)
				.url(url)
				.username(username)
				.password(password)
				.build();
	}
	
	@Bean(name="primaryJdbc")
	@Primary
	public JdbcTemplate createPrimaryJdbcTemplate(@Qualifier("primDataSource") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
