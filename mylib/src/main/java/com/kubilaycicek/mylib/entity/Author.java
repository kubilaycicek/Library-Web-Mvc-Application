package com.kubilaycicek.mylib.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Author extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, targetEntity = Book.class, mappedBy = "author")
	private List<Book> books;
}
