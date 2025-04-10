package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
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

	/**
	 * Finds all products with a price greater than the specified value.
	 * <p>
	 * This method allows filtering products based on a minimum price threshold.
	 * Spring Data JPA automatically implements this method based on its name
	 * following the pattern "findBy[PropertyName][GreaterThan]".
	 *
	 * @param price the minimum price threshold
	 * @return a list of products with prices greater than the specified value
	 */
	List<Product> findByPriceGreaterThan(double price);

	/**
	 * Finds all products whose name contains the specified keyword, ignoring case.
	 * <p>
	 * This method provides a case-insensitive partial match search on product names.
	 * For example, searching for "phone" would match "Smartphone", "iPhone", etc.
	 * Spring Data JPA automatically implements this method based on its name
	 * following the pattern "findBy[PropertyName][Containing][IgnoreCase]".
	 *
	 * @param keyword the search term to look for in product names
	 * @return a list of products whose names contain the keyword (case insensitive)
	 */
	List<Product> findByNameContainingIgnoreCase(String keyword);
}