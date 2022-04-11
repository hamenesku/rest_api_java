package com.singleton.dao;

import com.singleton.interfaces.ProductDao;
import com.singleton.proxy.Product;

public class ProductDaoProxy implements ProductDao {
	private final ProductDao productDao;

	public ProductDaoProxy(ProductDao productDao) {
		this.productDao = productDao;
	}

	public Product findById(Long id) {
		System.out.println("Logica de proxy antes de encontrar ...");
		Product p = this.productDao.findById(id);
		System.out.println("Logica de proxy despues de encontrar...");
		return p;
	}

	public Product save(Product product) {
		System.out.println("Logica de proxy antes de guardar ...");
		Product p = this.productDao.save(product);
		System.out.println("Logica de proxy despues de guardar ...");
		return p;
	}
}
