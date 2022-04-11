package com.singleton.proxy;

import com.singleton.interfaces.ProductDao;

public class ProductDaoImpl implements ProductDao {
	
	
	public Product findById(Long id) {
		System.out.println("Encontrando producto con id = " + id);
		return new Product(id, "Ejemplo");
	}

	public Product save(Product product) {
		System.out.println("Salvando producto....");
		return product;
	}
}