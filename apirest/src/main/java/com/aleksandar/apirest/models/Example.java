package com.aleksandar.apirest.models;

import org.springframework.stereotype.Component;

@Component
public class Example {
	int test;

	public Example(int test) {
		super();
		this.test = test;
	}
	
	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}


}
