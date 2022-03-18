package com.hieu.backend.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "author")
public class Author {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "biography", length = 1000)
	private String biography;
	
	@ManyToMany(mappedBy = "authors")
	@JsonIgnoreProperties("authors")
	private Set<Book> books;
	
	@ManyToMany(mappedBy = "authors")
	@JsonIgnoreProperties("authors")
	private Set<BookSet> book_sets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<BookSet> getBook_sets() {
		return book_sets;
	}

	public void setBook_sets(Set<BookSet> book_sets) {
		this.book_sets = book_sets;
	}
}
