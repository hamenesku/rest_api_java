package com.singleton.factory;

import com.singleton.abstracts.AbstractFactory;
import com.singleton.figures.Rectangle;
import com.singleton.figures.RoundedSquare;
import com.singleton.interfaces.Shape;

public class ShapeFactory extends AbstractFactory {
	   
	   @Override
	   public Shape getShape(String shapeType){    
	      if(shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();         
	      }else if(shapeType.equalsIgnoreCase("SQUARE")){
	         return new RoundedSquare();
	      }	 
	      return null;
	   }

	}
