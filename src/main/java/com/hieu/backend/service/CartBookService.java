package com.hieu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dao.CartBookDAO;
import com.hieu.backend.embeddable.CartBookKey;
import com.hieu.backend.entity.CartBook;

@Service
@Transactional
public class CartBookService {
	@Autowired
	private CartBookDAO cartBookDAO;
	
	public void add(CartBook cartBook) {
		cartBookDAO.persist(cartBook);
	}
	
	public void update(CartBook cartBook) {
		cartBookDAO.merge(cartBook);
	}
	
	public void delete(CartBookKey cartBookKey) {
		CartBook cartBook = cartBookDAO.findById(cartBookKey);
		if(cartBook != null) {
			cartBookDAO.remove(cartBook);
		}
	}
}
