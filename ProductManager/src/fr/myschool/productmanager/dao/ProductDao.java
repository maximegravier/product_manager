package fr.myschool.productmanager.dao;

import java.util.List;

import fr.myschool.productmanager.entity.Product;

public interface ProductDao {
	
	Product addProduct(Product product);
	Product findProductById(Long id);
	List<Product> getAllProducts();
	void updateProduct(Product product);
	void removeProduct(Product product);	
}
