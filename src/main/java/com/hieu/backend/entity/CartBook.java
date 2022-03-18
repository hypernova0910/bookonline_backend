package com.hieu.backend.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.hieu.backend.embeddable.CartBookKey;

@Entity
@Table (name = "cart__book")
public class CartBook {
	@EmbeddedId
    private CartBookKey id;
	
	@ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
	@JsonIncludeProperties({"id", "name", "thumb_nail", "sell_price", "discount_percent", "count"})
    private Book book;
	
	@ManyToOne
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id")
	@JsonIncludeProperties({"id"})
    private Cart cart;
	
	@Column(name = "book_count")
	private Integer book_count;
	
	@Column(name = "sell_price")
	private Integer sell_price;
	
	@Column(name = "total_money")
	private Integer total_money;
	
	@Column(name = "selected")
	private Boolean selected;

	public CartBookKey getId() {
		return id;
	}

	public void setId(CartBookKey id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getBook_count() {
		return book_count;
	}

	public void setBook_count(Integer book_count) {
		this.book_count = book_count;
	}

	public Integer getSell_price() {
		return sell_price;
	}

	public void setSell_price(Integer sell_price) {
		this.sell_price = sell_price;
	}

	public Integer getTotal_money() {
		return total_money;
	}

	public void setTotal_money(Integer total_money) {
		this.total_money = total_money;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
