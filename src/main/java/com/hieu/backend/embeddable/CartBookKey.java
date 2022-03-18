package com.hieu.backend.embeddable;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class CartBookKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6788795314057792315L;
	
	@Column(name = "book_id")
	private Long book_id;
	
	@Column(name = "cart_id")
	private Long cart_id;
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(this == o) {
			return true;
		}
		if(this.getClass() != o.getClass()) {
			return false;
		}
		CartBookKey other = (CartBookKey)o;
		return other.book_id == this.book_id && other.cart_id == this.cart_id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(book_id, cart_id);
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public Long getCart_id() {
		return cart_id;
	}

	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}
}
