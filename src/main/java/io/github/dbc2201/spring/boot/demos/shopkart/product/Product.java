package io.github.dbc2201.spring.boot.demos.shopkart.product;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private double price;

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
