package com.nikobit.spring.jpa.postgres.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {
    @ManyToOne(optional = false)
    private User user;

    private Long createdAt;
    private OrderState state;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<LineItem> lineItems = new HashSet<LineItem>();

    /**
     * Creates a new {@link Order} for the given user.
     *
     * @param user must not be {@literal null}.
     */
    public Order(User user, Long createdAt) {

        Assert.notNull(user, "Order must be linked to a user!");

        this.user = user;
        this.createdAt = createdAt;
        this.state = OrderState.CART;
    }

    protected Order() {
    }

    /**
     * Adds the given {@link LineItem} to the {@link Order}.
     *
     * @param lineItem
     */
    public void add(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    /**
     * Returns the {@link User} who placed the {@link Order}.
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    public OrderState getState() {
        return state;
    }

    /**
     * Returns all {@link LineItem}s currently belonging to the {@link Order}.
     *
     * @return
     */
    public Set<LineItem> getLineItems() {
        return Collections.unmodifiableSet(lineItems);
    }

    /**
     * Returns the total of the {@link Order}.
     *
     * @return
     */
    public Double getTotal() {

        Double total = 0.0;

        for (LineItem item : lineItems) {
            total += item.getTotal();
        }

        return total;
    }
}
