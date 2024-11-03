package com.mudit.Digital_Library.repository;

import com.mudit.Digital_Library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "select a from Author a where a.email = ?1")
    Author findByEmail(String email);
}
