package com.singleton.figures;

import com.singleton.interfaces.Shape;

public class RoundedSquare implements Shape{

	@Override
	public void draw() {
		System.out.println("Dentro de RoundedSquare::draw() metodo");	
	}

}
