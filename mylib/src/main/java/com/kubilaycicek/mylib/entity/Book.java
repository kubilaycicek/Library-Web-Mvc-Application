package com.kubilaycicek.mylib.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table
public class Book extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "subname")
	private String subname;
	@Column(name = "serialName")
	private String serialName;
	@Column(name = "isbn")
	private String isbnNumber;
	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false,targetEntity = Author.class)
	private Author author;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false,targetEntity = Publisher.class)
	private Publisher publisher;

}
