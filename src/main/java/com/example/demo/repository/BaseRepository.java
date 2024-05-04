package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseRepository {

	@Autowired
	@Qualifier("primaryJdbc")
	protected JdbcTemplate dbPrimary;
	
	@Autowired
	@Qualifier("secondaryJdbc")
	protected JdbcTemplate dbSecondary;
	
}
