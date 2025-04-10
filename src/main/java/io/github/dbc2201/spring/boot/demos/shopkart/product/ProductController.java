package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(@Qualifier("databaseProductService") ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product savedProduct = productService.createProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		Product product = productService.getProductById(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/byName")
	public ResponseEntity<Product> getProductByName(@RequestParam String name) {
		Product product = productService.getProductByName(name);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/price")
	public ResponseEntity<Product> updateProductPrice(
			@PathVariable long id,
			@RequestParam double price
	) {
		Product product = productService.updateProductPrice(id, price);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/name")
	public ResponseEntity<Product> updateProductName(
			@PathVariable long id,
			@RequestParam String name
	) {
		Product product = productService.updateProductName(id, name);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/description")
	public ResponseEntity<Product> updateProductDescription(
			@PathVariable long id,
			@RequestParam String description
	) {
		Product product = productService.updateProductDescription(id, description);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/imageUrl")
	public ResponseEntity<Product> updateProductImageUrl(
			@PathVariable long id,
			@RequestParam String imageUrl
	) {
		Product product = productService.updateProductImageUrl(id, imageUrl);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id) {
		boolean deleted = productService.deleteProduct(id);
		if (deleted) {
			return ResponseEntity.ok("Product deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
	}
}