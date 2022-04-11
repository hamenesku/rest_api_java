package com.singleton;

import com.singleton.interfaces.FirstInterface;
import com.singleton.interfaces.SecondInterface;

public class ClaseC implements SecondInterface{

    private static ClaseC claseC;
    
    private ClaseC(){
    	a1();
    }
    
    public static ClaseC createInstance() {
    	if ( claseC == null ) {
    		claseC = new ClaseC();
    	}
    	return claseC;
    }

	@Override
	public void a1() {
		// TODO Auto-generated method stub
		System.out.println("a1");
		
	}


	
    

}
