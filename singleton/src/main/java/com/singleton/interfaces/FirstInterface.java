package com.singleton.interfaces;

public interface FirstInterface {
	public void a1();
	
	public default void a2() {
		System.out.println("holi");
	}
//	public default String devuelveValor() {
//		return "test";
//	}
}
