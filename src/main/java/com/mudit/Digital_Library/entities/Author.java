package com.mudit.Digital_Library.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String country;
    @CreationTimestamp
    private Date addedOn;

    @OneToMany(mappedBy = "myAuthor") //Give the author name in the book entity
    private List<Book> bookList;
}
