package com.kubilaycicek.mylib.dto;

import com.kubilaycicek.mylib.entity.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@Data
@ToString
public class AuthorDto {
    private long id;
    private String name;
    private String description;
    private List<Book> books;

}
