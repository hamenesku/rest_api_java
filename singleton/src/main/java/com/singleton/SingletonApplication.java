package com.singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.singleton.abstracts.AbstractFactory;
import com.singleton.dao.ProductDaoProxy;
import com.singleton.factory.FactoryProducer;
import com.singleton.interfaces.FirstInterface;
import com.singleton.interfaces.Shape;
import com.singleton.objects.BankAccount;
import com.singleton.patron.PatronSingleton;
import com.singleton.proxy.Product;
import com.singleton.proxy.ProductDaoImpl;

@SpringBootApplication
public class SingletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonApplication.class, args);
		
//		PatronSingleton.creaInstancia();
//		PatronSingleton.verInstancia();
//		
//		ClaseC.createInstance();
		
//		NoImplementaMetodos sip = new NoImplementaMetodos();
//		FirstInterface 		nop = new NoImplementaMetodos();
		
		
//		Padre pepe = new Padre();
//		
//		
//		ProductDaoImpl prodImpl = new ProductDaoImpl();
//		ProductDaoProxy prodProx = new ProductDaoProxy(prodImpl);
		
		/* 
		//elegimos factoria
	      AbstractFactory shapeFactory =FactoryProducer.getFactory(false);
	      //conseguimos objeto de figura Rectangulo
	      Shape shape1 = shapeFactory.getShape("RECTANGLE");
	      //llamamos a su método pintar
	      shape1.draw();
	      //ahora objeto cuadrado 
	      Shape shape2 = shapeFactory.getShape("SQUARE");
	      //llamamos a su método pintar
	      shape2.draw();
	      //conseguimos otra factoria
	      AbstractFactory shapeFactory1 =FactoryProducer.getFactory(true);
	      Shape shape3 = shapeFactory1.getShape("RECTANGLE");
	  
	      shape3.draw();
	      
	      Shape shape4 = shapeFactory1.getShape("SQUARE");
	      shape4.draw();
			*/
		
		
		BankAccount account = new BankAccount.Builder(244L)
	            .withOwner("Marge")
	            .atBranch("Springfield")
	            .openingBalance(100)
	            .atRate(2.5)
	            .build();
		
		BankAccount account2 = new BankAccount.Builder(244L)
	            .withOwner("Marge")
	            .atBranch("Springfield")
	            .openingBalance(100)
	            .atRate(2.5)
	            .build();


		System.out.println("");
	}

}
