package com.nikobit.spring.jpa.postgres.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class LineItem extends AbstractEntity {
    @Column(name = "ordinal")
    private Integer ordinal;

    @ManyToOne
    private Product product;
    
    @Column(name = "quantity")
    private Integer quantity;

    public LineItem(Integer ordinal, Product product, Integer quantity) {
        this.ordinal = ordinal;
        this.product = product;
        this.quantity = quantity;
    }
}
