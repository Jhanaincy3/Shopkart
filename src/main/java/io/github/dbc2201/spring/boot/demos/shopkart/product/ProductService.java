package io.github.dbc2201.spring.boot.demos.shopkart.product;

import java.util.List;

public interface ProductService {
	Product createProduct(Product product) throws ProductValidationException;

	List<Product> getAllProducts() throws ProductNotFoundException;

	Product getProductById(long id) throws ProductNotFoundException;

	Product getProductByName(String name) throws ProductNotFoundException;

	Product updateProductPrice(long id, double newPrice) throws ProductValidationException;

	Product updateProductName(long id, String newName) throws ProductValidationException;

	Product updateProductDescription(long id, String newDescription) throws ProductValidationException;

	Product updateProductImageUrl(long id, String newImageUrl) throws ProductValidationException;

	boolean deleteProduct(long id) throws ProductNotFoundException;
}
