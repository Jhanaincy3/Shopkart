package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Product related endpoints.
 * This class handles HTTP requests related to Products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	@Autowired // dependency injection
	public ProductController(@Qualifier("databaseProductService") ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Creates a new product.
	 *
	 * @param product The product data from request body
	 * @return The newly created product
	 */
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	/**
	 * Gets all products.
	 *
	 * @return List of all products
	 */
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	/**
	 * Gets a product by its ID.
	 *
	 * @param id The ID of the product from path variable
	 * @return The found product
	 */
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}

	/**
	 * Gets a product by its name.
	 *
	 * @param name The name of the product from request parameter
	 * @return The found product
	 */
	@GetMapping("/byName")
	public Product getProductByName(@RequestParam String name) {
		return productService.getProductByName(name);
	}

	/**
	 * Updates the price of a product.
	 *
	 * @param id    The ID of the product from path variable
	 * @param price The new price from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/price")
	public Product updateProductPrice(@PathVariable long id, @RequestParam double price) {
		return productService.updateProductPrice(id, price);
	}

	/**
	 * Updates the name of a product.
	 *
	 * @param id   The ID of the product from path variable
	 * @param name The new name from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/name")
	public Product updateProductName(@PathVariable long id, @RequestParam String name) {
		return productService.updateProductName(id, name);
	}

	/**
	 * Updates the description of a product.
	 *
	 * @param id          The ID of the product from path variable
	 * @param description The new description from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/description")
	public Product updateProductDescription(@PathVariable long id, @RequestParam String description) {
		return productService.updateProductDescription(id, description);
	}

	/**
	 * Updates the image URL of a product.
	 *
	 * @param id       The ID of the product from path variable
	 * @param imageUrl The new image URL from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/imageUrl")
	public Product updateProductImageUrl(@PathVariable long id, @RequestParam String imageUrl) {
		return productService.updateProductImageUrl(id, imageUrl);
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id The ID of the product from path variable
	 * @return A message indicating success or failure
	 */
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable long id) {
		boolean deleted = productService.deleteProduct(id);
		if (deleted) {
			return "Product deleted successfully";
		} else {
			return "Product not found";
		}
	}
}