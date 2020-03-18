package com.kubilaycicek.mylib.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class AuthorDto {
    private long id;
    private String name;
    private String description;

}
