package com.nikobit.spring.jpa.postgres.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LineItem extends AbstractEntity {
    private Integer ordinal;

    @ManyToOne
    private Product product;

    private Integer quantity;

    /**
     * Creates a new {@link LineItem} for the given {@link Product} and quantity.
     *
     * @param ordinal item's ordinal in a cart
     * @param product must not be {@literal null}.
     * @param quantity
     */
    public LineItem(Integer ordinal, Product product, Integer quantity) {

        Assert.notNull(product, "The given Product must not be null!");
        Assert.isTrue(quantity > 0, "The quantity of Products to be bought must be greater than 0!");

        this.ordinal = ordinal;
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the total for the {@link LineItem}.
     *
     * @return
     */
    public Double getTotal() {
        return quantity * product.getPrice();
    }
}
