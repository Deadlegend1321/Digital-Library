package com.mudit.Digital_Library.service;

import com.mudit.Digital_Library.dtos.CreateBookRequest;
import com.mudit.Digital_Library.dtos.SearchBookRequest;
import com.mudit.Digital_Library.entities.Author;
import com.mudit.Digital_Library.entities.Book;
import com.mudit.Digital_Library.entities.enums.Genre;
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

    public List<Book> search(SearchBookRequest searchBookRequest) throws Exception{
        boolean isValidRequest = searchBookRequest.validate();
        if(!isValidRequest){
            throw new Exception("Invalid Request");
        }
        switch (searchBookRequest.getSearchKey()) {
            case "name":
                return bookRepository.findByName(searchBookRequest.getSearchValue());
            case "genre":
                return bookRepository.findByGenre(Genre.valueOf(searchBookRequest.getSearchValue()));
            case "id":
                return bookRepository.findAllById(Integer.valueOf(searchBookRequest.getSearchValue()));
            default:
                throw new IllegalArgumentException("Unexpected value: " + searchBookRequest.getSearchValue());
        }
    }
}
