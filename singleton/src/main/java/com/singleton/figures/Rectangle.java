package com.singleton.figures;

import com.singleton.interfaces.Shape;

public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Dentro de Rectangle::draw() metodo");
	}

}
