package com.mudit.Digital_Library.dtos;

import com.mudit.Digital_Library.entities.Author;
import com.mudit.Digital_Library.entities.Book;
import com.mudit.Digital_Library.entities.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank
    private String name;
    @NotNull
    private Genre genre;
    private int pages;
    @NotBlank
    private String authorName;
    private String authorCountry;
    @NotBlank
    private String authorEmail;

    public Book to() {
        return Book.builder()
                .name(name)
                .pages(pages)
                .genre(genre)
                .myAuthor(Author.builder().name(authorName).country(authorCountry).email(authorEmail).build())
                .build();
    }
}
