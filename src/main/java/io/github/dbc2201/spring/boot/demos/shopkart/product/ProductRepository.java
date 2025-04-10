package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing {@link Product} entities in the database.
 * <p>
 * This interface extends {@link JpaRepository} which provides standard CRUD operations:
 * <ul>
 *     <li>{@code save(Product entity)}: Saves a product entity to the database</li>
 *     <li>{@code findById(Long id)}: Finds a product by its ID</li>
 *     <li>{@code findAll()}: Retrieves all products</li>
 *     <li>{@code deleteById(Long id)}: Deletes a product by its ID</li>
 *     <li>{@code delete(Product entity)}: Deletes a specific product entity</li>
 *     <li>{@code count()}: Returns the total number of products</li>
 *     <li>{@code existsById(Long id)}: Checks if a product with given ID exists</li>
 * </ul>
 * <p>
 * The {@code @Repository} annotation marks this interface as a Spring Data repository,
 * which allows Spring to find and configure it automatically.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Finds a product by its name.
	 * <p>
	 * This custom method is created because JpaRepository doesn't provide a
	 * built-in method to search by the product name. Spring Data JPA will automatically
	 * implement this method based on its name following the pattern "findBy[PropertyName]".
	 * <p>
	 * The method returns an Optional object which may or may not contain a Product,
	 * avoiding potential null pointer exceptions when no product is found with the given name.
	 *
	 * @param name the name of the product to search for
	 * @return an Optional containing the found product, or an empty Optional if no product exists with the given name
	 */
	Optional<Product> findByName(String name);
}