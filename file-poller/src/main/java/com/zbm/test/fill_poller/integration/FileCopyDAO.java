package com.zbm.test.fill_poller.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class FileCopyDAO {
	
	@Autowired
	private JdbcOperations jdbcTemplate;
	
	public void addFileCopy() {
		
	}

}
