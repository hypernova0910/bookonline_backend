package com.hieu.backend.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.hieu.backend.dto.BookDTO;

@Entity
@Table (name = "book")
@SqlResultSetMapping(
    name = "BookMapping",
    classes = @ConstructorResult(
        targetClass = BookDTO.class,
        columns = {
            @ColumnResult(name = "id", type=Long.class),
            @ColumnResult(name = "name"),
            @ColumnResult(name = "thumb_nail"),
            @ColumnResult(name = "translator"),
            @ColumnResult(name = "publish_year"),
            @ColumnResult(name = "cover_form"),
            @ColumnResult(name = "cover_formST"),
            @ColumnResult(name = "weight", type=Float.class),
            @ColumnResult(name = "length", type=Float.class),
            @ColumnResult(name = "width", type=Float.class),
            @ColumnResult(name = "page_count"),
            @ColumnResult(name = "description"),
            @ColumnResult(name = "count"),
            @ColumnResult(name = "buy_price"),
            @ColumnResult(name = "sell_price"),
            @ColumnResult(name = "discount_percent", type=Float.class),
            @ColumnResult(name = "class_id"),
            @ColumnResult(name = "class_idST"),
            @ColumnResult(name = "class_level_id"),
            @ColumnResult(name = "class_level_idST"),
            @ColumnResult(name = "language_id"),
            @ColumnResult(name = "language_idST"),
            @ColumnResult(name = "provider_id", type=Long.class),
            @ColumnResult(name = "provider_idST"),
            @ColumnResult(name = "publisher_id", type=Long.class),
            @ColumnResult(name = "publisher_idST"),
            @ColumnResult(name = "episode"),
            @ColumnResult(name = "book_set_id", type=Long.class),
            @ColumnResult(name = "book_set_idST"),
            @ColumnResult(name = "author_idST"),
        }
    )
)
public class Book {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "thumb_nail")
	private String thumb_nail;
	
	@ManyToMany
	@JoinTable(
	  name = "book__author", 
	  joinColumns = @JoinColumn(name = "book_id"), 
	  inverseJoinColumns = @JoinColumn(name = "author_id"))
	@JsonIncludeProperties({"id", "name"})
	private Set<Author> authors;
	
	@Column (name = "translator")
	private String translator;
	
	@Column (name = "publish_year")
	private Integer publish_year;
	
	@Column (name = "cover_form")
	private Integer cover_form;
	
	@Column (name = "weight")
	private Float weight;
	
	@Column (name = "length")
	private Float length;
	
	@Column (name = "width")
	private Float width;
	
	@Column (name = "page_count")
	private Integer page_count;
	
	@Column (name = "description", length = 4000)
	private String description;
	
	@Column (name = "count")
	private Integer count;
	
	@Column (name = "buy_price")
	private Integer buy_price;
	
	@Column (name = "sell_price")
	private Integer sell_price;
	
	@Column (name = "discount_percent")
	private Float discount_percent;
	
	@ManyToMany
	@JoinTable(
	  name = "book__product_group", 
	  joinColumns = @JoinColumn(name = "book_id"), 
	  inverseJoinColumns = @JoinColumn(name = "product_group_id"))
	@JsonIncludeProperties({"id", "name"})
	private Set<ProductGroup> productGroups;
	
	@ManyToOne
	@JoinColumn (name = "book_set_id")
	@JsonIncludeProperties({"id", "name"})
	private BookSet bookSet;
	
	@ManyToOne
	@JoinColumn (name = "publisher_id")
	@JsonIncludeProperties({"id", "name"})
	private Publisher publisher;
	
	@ManyToOne
	@JoinColumn (name = "provider_id")
	@JsonIncludeProperties({"id", "name"})
	private Provider provider;
	
	@Column (name = "class_id")
	private Integer class_id;
	
	@Column (name = "class_level_id")
	private Integer class_level_id;
	
	@Column (name = "language_id")
	private Integer language_id;
	
	@Column (name = "episode")
	private Integer episode;
	
	@ManyToMany
	@JoinTable(
	  name = "book__genre", 
	  joinColumns = @JoinColumn(name = "book_id"), 
	  inverseJoinColumns = @JoinColumn(name = "genre_id"))
	@JsonIncludeProperties({"id", "name"})
	private Set<Genre> genres;
	
	@OneToMany(mappedBy = "book")
	private Set<CartBook> cartBooks;

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

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Integer getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(Integer publish_year) {
		this.publish_year = publish_year;
	}

	public Integer getCover_form() {
		return cover_form;
	}

	public void setCover_form(Integer cover_form) {
		this.cover_form = cover_form;
	}

	public Integer getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(Integer buy_price) {
		this.buy_price = buy_price;
	}

	public Integer getSell_price() {
		return sell_price;
	}

	public void setSell_price(Integer sell_price) {
		this.sell_price = sell_price;
	}

	public Float getDiscount_percent() {
		return discount_percent;
	}

	public void setDiscount_percent(Float discount_percent) {
		this.discount_percent = discount_percent;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getThumb_nail() {
		return thumb_nail;
	}

	public void setThumb_nail(String thumb_nail) {
		this.thumb_nail = thumb_nail;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Integer getPage_count() {
		return page_count;
	}

	public void setPage_count(Integer page_count) {
		this.page_count = page_count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BookSet getBookSet() {
		return bookSet;
	}

	public void setBookSet(BookSet bookSet) {
		this.bookSet = bookSet;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public Integer getClass_level_id() {
		return class_level_id;
	}

	public void setClass_level_id(Integer class_level_id) {
		this.class_level_id = class_level_id;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<ProductGroup> getProductGroups() {
		return productGroups;
	}

	public void setProductGroups(Set<ProductGroup> productGroups) {
		this.productGroups = productGroups;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public Integer getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public Set<CartBook> getCartBooks() {
		return cartBooks;
	}

	public void setCartBooks(Set<CartBook> cartBooks) {
		this.cartBooks = cartBooks;
	}
}
