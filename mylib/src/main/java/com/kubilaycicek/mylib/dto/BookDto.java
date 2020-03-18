package com.kubilaycicek.mylib.dto;

import lombok.Data;

@Data
public class BookDto {
    private long id;
    private String name;
    private String subName;
    private String serialName;
    private String isbnNumber;
    private AuthorDto authorDto;
    private PublisherDto publisherDto;
    private String description;
}
