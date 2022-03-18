package com.hieu.backend.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.embeddable.CartBookKey;
import com.hieu.backend.entity.CartBook;

@Repository(value = "cartBookDAO")
@Transactional(rollbackFor = Exception.class)
public class CartBookDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public CartBook findById(final CartBookKey id) {
		return entityManager.find(CartBook.class, id);
	}
	
	public void persist(final CartBook cartBook) {
		entityManager.persist(cartBook);
	}
	
	public void merge(final CartBook cartBook) {
		entityManager.merge(cartBook);
	}
	
	public void remove(final CartBook cartBook) {
		entityManager.remove(cartBook);
	}
}
