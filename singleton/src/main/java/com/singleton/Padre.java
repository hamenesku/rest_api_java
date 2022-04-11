package com.singleton;

import com.singleton.abstracts.Familia;

public class Padre extends Familia{
	
	public Padre() {
		casa();
		sentimientos();
	}

	@Override
	public void sentimientos() {
		System.out.println("no siento nada");
		
	}

}
