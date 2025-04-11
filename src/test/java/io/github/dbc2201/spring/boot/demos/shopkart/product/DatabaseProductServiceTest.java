package io.github.dbc2201.spring.boot.demos.shopkart.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for the DatabaseProductService class.
 * Uses Mockito to mock the repository layer.
 */
@ExtendWith(MockitoExtension.class)
class DatabaseProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private DatabaseProductService productService;

	private Product testProduct;

	/**
	 * Set up test data before each test.
	 */
	@BeforeEach
	void setUp() {
		testProduct = new Product(
				"Test Product",
				"This is a test product",
				99.99,
				"https://example.com/image.jpg"
		);
		testProduct.setId(1L);
	}

	/**
	 * Test that a product can be created successfully.
	 */
	@Test
	@DisplayName("Should create a product when given valid data")
	void testCreateProduct() {
		// Arrange
		when(productRepository.save(any(Product.class))).thenReturn(testProduct);

		// Act
		Product created = productService.createProduct(testProduct);

		// Assert
		assertNotNull(created);
		assertEquals(testProduct.getName(), created.getName());
		verify(productRepository).save(testProduct);
	}

	/**
	 * Test that an exception is thrown when trying to create a null product.
	 */
	@Test
	@DisplayName("Should throw exception when creating null product")
	void testCreateNullProduct() {
		// Act & Assert
		assertThrows(ProductValidationException.class, () -> productService.createProduct(null));

		verify(productRepository, never()).save(any());
	}

	/**
	 * Test retrieving all products.
	 */
	@Test
	@DisplayName("Should return all products")
	void testGetAllProducts() {
		// Arrange
		Product product2 = new Product(
				"Another Product",
				"Another test product",
				49.99,
				"http://example.com/image2.jpg"
		);
		product2.setId(2L);

		when(productRepository.findAll()).thenReturn(Arrays.asList(testProduct, product2));

		// Act
		List<Product> products = productService.getAllProducts();

		// Assert
		assertEquals(2, products.size());
		assertEquals("Test Product", products.get(0).getName());
		assertEquals("Another Product", products.get(1).getName());
	}

	/**
	 * Test that a product can be retrieved by ID.
	 */
	@Test
	@DisplayName("Should return product when ID exists")
	void testGetProductById() {
		// Arrange
		when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));

		// Act
		Product found = productService.getProductById(1L);

		// Assert
		assertNotNull(found);
		assertEquals(1L, found.getId());
		assertEquals("Test Product", found.getName());
	}

	/**
	 * Test that an exception is thrown when a product is not found by ID.
	 */
	@Test
	@DisplayName("Should throw exception when product ID doesn't exist")
	void testGetProductByIdNotFound() {
		// Arrange
		when(productRepository.findById(99L)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(ProductNotFoundException.class, () -> {
			productService.getProductById(99L);
		});
	}
}