package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing Product operations.
 * This class handles business logic related to Products.
 */
@Service
public class InMemoryProductService implements ProductService {

	// Using an ArrayList to store products (in-memory storage)
	private final List<Product> products;

	public InMemoryProductService() {
		this.products = new ArrayList<>();
	}

	/**
	 * Creates a new product and adds it to the list.
	 *
	 * @param product The product to be created and stored
	 * @return The newly created product
	 */
	@Override
	public Product createProduct(Product product) {
		products.add(product);
		return product;
	}

	/**
	 * Retrieves all products from the list.
	 *
	 * @return List of all products
	 */
	@Override
	public List<Product> getAllProducts() {
		return products;
	}

	/**
	 * Finds a product by its ID.
	 *
	 * @param id The ID of the product to find
	 * @return The found product or null if not found
	 */
	@Override
	public Product getProductById(long id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	/**
	 * Finds a product by its name.
	 *
	 * @param name The name of the product to find
	 * @return The found product or null if not found
	 */
	@Override
	public Product getProductByName(String name) {
		for (Product product : products) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	/**
	 * Updates the price of a product identified by its ID.
	 *
	 * @param id       The ID of the product to update
	 * @param newPrice The new price to set
	 * @return The updated product or null if not found
	 */
	@Override
	public Product updateProductPrice(long id, double newPrice) {
		Product product = getProductById(id);
		if (product != null) {
			product.setPrice(newPrice);
		}
		return product;
	}

	/**
	 * Updates the name of a product identified by its ID.
	 *
	 * @param id      The ID of the product to update
	 * @param newName The new name to set
	 * @return The updated product or null if not found
	 */
	@Override
	public Product updateProductName(long id, String newName) {
		Product product = getProductById(id);
		if (product != null) {
			product.setName(newName);
		}
		return product;
	}

	/**
	 * Updates the description of a product identified by its ID.
	 *
	 * @param id             The ID of the product to update
	 * @param newDescription The new description to set
	 * @return The updated product or null if not found
	 */
	@Override
	public Product updateProductDescription(long id, String newDescription) {
		Product product = getProductById(id);
		if (product != null) {
			product.setDescription(newDescription);
		}
		return product;
	}

	/**
	 * Updates the image URL of a product identified by its ID.
	 *
	 * @param id          The ID of the product to update
	 * @param newImageUrl The new image URL to set
	 * @return The updated product or null if not found
	 */
	@Override
	public Product updateProductImageUrl(long id, String newImageUrl) {
		Product product = getProductById(id);
		if (product != null) {
			product.setImageUrl(newImageUrl);
		}
		return product;
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id The ID of the product to delete
	 * @return true if product was deleted, false if not found
	 */
	@Override
	public boolean deleteProduct(long id) {
		Product product = getProductById(id);
		if (product != null) {
			products.remove(product);
			return true;
		}
		return false;
	}
}