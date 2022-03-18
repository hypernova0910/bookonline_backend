package com.hieu.backend.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "book_set")
public class BookSet {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable(
	  name = "book_set__genre", 
	  joinColumns = @JoinColumn(name = "book_set_id"), 
	  inverseJoinColumns = @JoinColumn(name = "genre_id"))
	@JsonIgnoreProperties({"books", "book_sets"})
	private Set<Genre> genres;
	
	@ManyToMany
	@JoinTable(
	  name = "book_set__author", 
	  joinColumns = @JoinColumn(name = "book_set_id"), 
	  inverseJoinColumns = @JoinColumn(name = "author_id"))
	@JsonIgnoreProperties({"books", "book_sets"})
	private Set<Author> authors;

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

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
}
