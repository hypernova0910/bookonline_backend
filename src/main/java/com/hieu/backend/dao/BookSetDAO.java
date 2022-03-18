package com.hieu.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.entity.BookSet;

@Repository(value = "bookSetDAO")
@Transactional(rollbackFor = Exception.class)
public class BookSetDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public BookSet findById(final Long id) {
	    return entityManager.find(BookSet.class, id);
	}
	
	public List<BookSet> findAll(int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<BookSet> cq = cb.createQuery(BookSet.class);
		Root<BookSet> root = cq.from(BookSet.class);
		TypedQuery<BookSet> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		if(limit > 0) {
			query.setMaxResults(limit);
		}
	    return query.getResultList();
	}
	
	public Long persist(final BookSet bookSet) {
		entityManager.persist(bookSet);
		return bookSet.getId();
	}
	
	public void merge(final BookSet bookSet) {
		entityManager.merge(bookSet);
	}
}
