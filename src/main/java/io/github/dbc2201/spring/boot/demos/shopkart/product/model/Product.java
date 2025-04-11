package io.github.dbc2201.spring.boot.demos.shopkart.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * The name of the product.
	 * Cannot be empty, and must be between 4 and 50 characters.
	 */
	@NotBlank(message = "Product name is required.")
	@Size(min = 4, max = 50, message = "Product name must be between 4 and 50 characters.")
	@Column(nullable = false)
	private String name;

	/**
	 * The description of the product.
	 * Cannot be empty, and must be between 10 and 100 characters.
	 */
	@NotBlank(message = "Product description is required.")
	@Size(min = 10, max = 100, message = "Product description must be between 10 and 100 characters.")
	@Column(nullable = false)
	private String description;

	/**
	 * The price of the product. Must be a positive number greater than 0.
	 */
	@NotNull(message = "Product price is required.")
	@Min(value = 0, message = "Product price must be greater than or equal to 0.")
	@Column(nullable = false)
	private double price;

	/**
	 * The URL of the product image.
	 * Must be a valid URL format.
	 */
	@NotBlank(message = "Product image URL is required.")
	@URL(message = "Please provide a valid image URL for the product image.")
	@Column(nullable = false)
	private String imageUrl;

	public Product() {
	}

	public Product(String name, String description, double price, String imageUrl) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;
		return id == product.id && Double.compare(price, product.price) == 0
				&& Objects.equals(name, product.name)
				&& Objects.equals(description, product.description)
				&& Objects.equals(imageUrl, product.imageUrl);
	}

	@Override
	public int hashCode() {
		int result = Long.hashCode(id);
		result = 31 * result + Objects.hashCode(name);
		result = 31 * result + Objects.hashCode(description);
		result = 31 * result + Double.hashCode(price);
		result = 31 * result + Objects.hashCode(imageUrl);
		return result;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", imageUrl='" + imageUrl + '\'' +
				'}';
	}
}
