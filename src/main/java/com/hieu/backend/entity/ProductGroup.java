package com.hieu.backend.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "product_group")
public class ProductGroup {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "link", unique = true)
	private String link;
	
	@ManyToOne
	@JoinColumn (name = "parent_id")
	@JsonIgnoreProperties("productGroups")
	private ProductGroup parent_group;
	
	@ManyToMany(mappedBy = "productGroups")
	@JsonIgnore
	private Set<Book> books;

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ProductGroup getParent_group() {
		return parent_group;
	}

	public void setParent_group(ProductGroup parent_group) {
		this.parent_group = parent_group;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
