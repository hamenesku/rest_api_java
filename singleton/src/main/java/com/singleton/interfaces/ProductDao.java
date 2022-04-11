package com.singleton.interfaces;

import com.singleton.proxy.Product;

public interface ProductDao {
	public Product findById(Long id);

	public Product save(Product product);


}