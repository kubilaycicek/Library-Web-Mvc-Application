package com.kubilaycicek.mylib.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Publisher extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Book.class, cascade = CascadeType.ALL, mappedBy = "publisher")
    private List<Book> books;

}
