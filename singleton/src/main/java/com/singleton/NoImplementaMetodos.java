package com.singleton;

import com.singleton.interfaces.FirstInterface;

public class NoImplementaMetodos implements FirstInterface{
	public NoImplementaMetodos() {
		a1();
		a2();
	}

	@Override
	public void a1() {
		System.out.println("a1");
		
	}

}
