package com.kubilaycicek.mylib.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@Data
@ToString
public class PublisherDto {
    private long id;
    private String name;
    private String description;
}
