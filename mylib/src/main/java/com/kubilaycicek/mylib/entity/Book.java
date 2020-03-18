package com.kubilaycicek.mylib.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table
@ToString
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String name;
	@Column
	private String subname;
	@Column
	private String serialName;
	@Column
	private String isbnNumber;
	@Column
	private String description;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false,targetEntity = Author.class)
	private Author author;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false,targetEntity = Publisher.class)
	private Publisher publisher;

}
