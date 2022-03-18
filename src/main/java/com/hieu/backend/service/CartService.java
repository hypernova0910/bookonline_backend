package com.hieu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dao.CartBookDAO;
import com.hieu.backend.dao.CartDAO;
import com.hieu.backend.entity.Cart;
import com.hieu.backend.entity.CartBook;

@Service
@Transactional
public class CartService {
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CartBookDAO cartBookDAO;
	
	public Cart findById(final Long id) {
		return cartDAO.findById(id);
	}
	
	public Long add(final Cart cart) {
		return cartDAO.persist(cart);
	}
	
	public void update(final Cart cart) {
		if(cart.getCartBooks() != null) {
			for(CartBook cartBook : cart.getCartBooks()) {
//				if(cartBookDAO.findById(cartBook.getId()) == null) {
//					cartBookDAO.persist(cartBook);
//				}
//				else {
//					cartBookDAO.merge(cartBook);
//				}
				cartBookDAO.merge(cartBook);
			}
		}
		cartDAO.merge(cart);
	}
	
	public Cart getCartByCustomerId(Long customerId) {
		if(cartDAO.count(customerId) > 0) {
			return cartDAO.getCartByCustomerId(customerId);
		}
		else {
			return new Cart();
		}
	}
}
