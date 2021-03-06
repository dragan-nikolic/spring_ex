package com.nikobit.spring.jpa.postgres.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikobit.spring.jpa.postgres.model.Tutorial;

/**
 * JpaRepository supports some methods by default:
 * - save()
 * - findOne()
 * - findById
 * - findAll()
 * - count()
 * - delete()
 * - deleteById()
 *
 * Here we add methods that are not supported by default.
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
}