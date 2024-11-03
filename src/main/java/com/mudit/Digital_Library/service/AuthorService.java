package com.mudit.Digital_Library.service;

import com.mudit.Digital_Library.entities.Author;
import com.mudit.Digital_Library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author createOrGet(Author author) {
        Author authorFromDB = this.authorRepository.findByEmail(author.getEmail());

        if(authorFromDB != null){
            return authorFromDB;
        }

        return this.authorRepository.save(author);
    }
}
