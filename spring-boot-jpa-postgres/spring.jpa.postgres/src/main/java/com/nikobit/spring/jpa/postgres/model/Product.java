package com.nikobit.spring.jpa.postgres.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    /**
     * Creates a new {@link Product} from the given name and price.
     *
     * @param name must not be {@literal null} or empty.
     * @param price must not be {@literal null} or less than or equal to zero.
     */
    public Product(String name, Double price, Integer quantity) {

        Assert.hasText(name, "Name must not be null or empty!");
        Assert.isTrue(price > 0, "Price must be greater than zero!");

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
