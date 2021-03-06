package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.InterfazDAO;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private InterfazDAO repository;

	@Test
	void contextLoads() {
//		Assertions.assertEquals(getRepository().exists(null));
		Assertions.assertNotNull(getRepository());
	}

	public InterfazDAO getRepository() {
		return repository;
	}

	public void setRepository(InterfazDAO repository) {
		this.repository = repository;
	}
}
