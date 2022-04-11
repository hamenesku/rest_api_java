package com.singleton.factory;

import com.singleton.abstracts.AbstractFactory;

public class FactoryProducer {
	   public static AbstractFactory getFactory(boolean rounded){   
	      if(rounded){
	         return new RoundedShapeFactory();         
	      }else{
	         return new ShapeFactory();
	      }
	   }
	}
