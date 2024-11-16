package com.mudit.Digital_Library.controller;


import com.mudit.Digital_Library.dtos.CreateBookRequest;
import com.mudit.Digital_Library.dtos.SearchBookRequest;
import com.mudit.Digital_Library.entities.Book;
import com.mudit.Digital_Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @PostMapping("")
    public Book createBook(@RequestBody CreateBookRequest createBookRequest){
        return bookService.create(createBookRequest);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.get();
    }

    @GetMapping("/search")
    public List<Book> getBooks(@RequestBody SearchBookRequest searchBookRequest) throws Exception {
        return bookService.search(searchBookRequest);
    }
}
