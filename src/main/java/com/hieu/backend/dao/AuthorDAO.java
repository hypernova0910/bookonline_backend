package com.hieu.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.entity.Author;

@Repository(value = "authorDAO")
@Transactional(rollbackFor = Exception.class)
public class AuthorDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public Author findById(final Long id) {
	    return entityManager.find(Author.class, id);
	}

	public List<Author> findAll(int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Author> cq = cb.createQuery(Author.class);
		Root<Author> root = cq.from(Author.class);
		TypedQuery<Author> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		if(limit > 0) {
			query.setMaxResults(limit);
		}
	    return query.getResultList();
	}
	
	public Long persist(final Author author) {
		entityManager.persist(author);
		return author.getId();
	}
	
	public void merge(final Author author) {
		entityManager.merge(author);
	}
	
	public void remove(final Author author) {
		entityManager.remove(author);
	}
}
