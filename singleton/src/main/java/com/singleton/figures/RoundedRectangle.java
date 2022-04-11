package com.singleton.figures;

import com.singleton.interfaces.Shape;

public class RoundedRectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Dentro de RoundedRectangle::draw() metodo");
	}

}
