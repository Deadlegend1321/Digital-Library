package com.mudit.Digital_Library.service;

import com.mudit.Digital_Library.dtos.CreateBookRequest;
import com.mudit.Digital_Library.entities.Author;
import com.mudit.Digital_Library.entities.Book;
import com.mudit.Digital_Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public Book create(CreateBookRequest createBookRequest){
        Book book = createBookRequest.to();
        Author author = authorService.createOrGet(book.getMyAuthor());
        book.setMyAuthor(author);
        return bookRepository.save(book);
    }

    public List<Book> get(){
        return bookRepository.findAll();
    }
}
