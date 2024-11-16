package com.mudit.Digital_Library.repository;

import com.mudit.Digital_Library.entities.Book;
import com.mudit.Digital_Library.entities.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select b from Book b where b.name like %?1")
    public List<Book> findByName(String name);

    @Query(value = "select b from Book b where b.genre = ?1")
    public List<Book> findByGenre(Genre genre);

    @Query(value = "select b from Book b where b.id = ?1")
    public List<Book> findAllById(int id);
}
