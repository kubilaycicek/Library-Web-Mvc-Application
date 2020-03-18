package com.kubilaycicek.mylib.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
@ToString
public class Publisher implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String description;
    
    @OneToMany(fetch = FetchType.LAZY,
    		targetEntity = Book.class,
    		orphanRemoval = true,mappedBy = "publisher")
    private List<Book> books;

}
