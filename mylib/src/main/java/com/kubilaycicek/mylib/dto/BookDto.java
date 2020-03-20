package com.kubilaycicek.mylib.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@Data
@ToString
public class BookDto {
    private long id;
    private String name;
    private String subName;
    private String serialName;
    private String isbnNumber;
    private String description;
    private AuthorDto authorDto;
    private PublisherDto publisherDto;
}
