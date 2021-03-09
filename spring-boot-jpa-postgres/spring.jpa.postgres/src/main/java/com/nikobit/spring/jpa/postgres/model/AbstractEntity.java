package com.nikobit.spring.jpa.postgres.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class to derive entity classes from.
 */
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Returns the identifier of the entity.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }
}
