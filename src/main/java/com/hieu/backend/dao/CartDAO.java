package com.hieu.backend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.entity.Book;
import com.hieu.backend.entity.Cart;
import com.hieu.backend.entity.Customer;

@Repository(value = "cartDAO")
@Transactional(rollbackFor = Exception.class)
public class CartDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public Cart findById(final Long id) {
		return entityManager.find(Cart.class, id);
	}
	
	public Long count(Long customerId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Cart> root = cq.from(Cart.class);
		cq.select(cb.count(root));
		List<Predicate> pre = new ArrayList<>();
		if(customerId != null) {
			pre.add(cb.equal(root.get("customer").get("id"), customerId));
		}
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Long> query = entityManager.createQuery(cq);
	    return query.getSingleResult();
	}
	
	public Cart getCartByCustomerId(Long customerId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cart> cq = cb.createQuery(Cart.class);
		Root<Cart> root = cq.from(Cart.class);
		List<Predicate> pre = new ArrayList<>();
		if(customerId != null) {
			pre.add(cb.equal(root.get("customer").get("id"), customerId));
		}
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Cart> query = entityManager.createQuery(cq);
		Cart cart = query.getSingleResult();
		System.out.println(cart.getCartBooks().size());
	    return cart;
	}
	
	public Long persist(final Cart cart) {
		entityManager.persist(cart);
		return cart.getId();
	}
	
	public void merge(final Cart cart) {
		entityManager.merge(cart);
	}
}
