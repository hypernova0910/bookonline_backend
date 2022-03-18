package com.hieu.backend.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@Entity
@Table (name = "cart")
public class Cart {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	@JsonIncludeProperties({"id", "phone", "email"})
    private Customer customer;
	
	@OneToMany(mappedBy = "cart")
	@OrderBy("id")
	private List<CartBook> cartBooks;
	
	@Column(name = "sum_money")
	private Integer sum_money;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartBook> getCartBooks() {
		return cartBooks;
	}

	public void setCartBooks(List<CartBook> cartBooks) {
		this.cartBooks = cartBooks;
	}

	public Integer getSum_money() {
		return sum_money;
	}

	public void setSum_money(Integer sum_money) {
		this.sum_money = sum_money;
	}
}
