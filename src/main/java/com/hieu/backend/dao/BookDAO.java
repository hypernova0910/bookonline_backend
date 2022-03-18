package com.hieu.backend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dto.BookDTO;
import com.hieu.backend.entity.Book;
import com.hieu.backend.entity.Genre;
import com.hieu.backend.metamodel.Book_;

@Repository(value = "bookDAO")
@Transactional(rollbackFor = Exception.class)
public class BookDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public Long persist(final Book book) {
		entityManager.persist(book);
		return book.getId();
	}
	
	public Book findById(final Long id) {
	    return entityManager.find(Book.class, id);
	}
	
	public List<Book> findAll(int offset, int limit, 
			Long productGroupId,
			Double minPrice,
			Double maxPrice, 
			List<Long> genres,
			Long bookSetId,
			String orderBy,
			boolean isAsc
		) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> bookRoot = cq.from(Book.class);
		List<Predicate> pre = new ArrayList<>();
		if(productGroupId != null) {
			pre.add(cb.equal(bookRoot.join("productGroups").get("id"), productGroupId));
		}
		if(minPrice != null) {
			pre.add(cb.ge(bookRoot.get("sell_price"), minPrice));
		}
		if(maxPrice != null) {
			pre.add(cb.le(bookRoot.get("sell_price"), maxPrice));
		}
		if(genres != null) {
			if(!genres.isEmpty()) {
				pre.add(bookRoot.joinSet("genres").in(genres));
				cq.distinct(true);
			}
		}
		if(bookSetId != null) {
			pre.add(cb.equal(bookRoot.get("bookSet").get("id"), bookSetId));
		}
		cq.where(pre.toArray(new Predicate[pre.size()]));
		if(orderBy != null) {
			if(!orderBy.isBlank()) {
				try {
					if(isAsc) {
						cq.orderBy(cb.asc(bookRoot.get(orderBy)));
					}
					else {
						cq.orderBy(cb.desc(bookRoot.get(orderBy)));
					}
				}catch(Exception e) {
					return new ArrayList<>();
				}
				
			}
		}
		
		TypedQuery<Book> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		if(limit > 0) {
			query.setMaxResults(limit);
		}
	    return query.getResultList();
	}
	
	public Long count(
			Long productGroupId,
			Double minPrice,
			Double maxPrice, 
			List<Long> genres,
			Long bookSetId
		) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Book> bookRoot = cq.from(Book.class);
		cq.select(cb.count(bookRoot));
		List<Predicate> pre = new ArrayList<>();
		if(productGroupId != null) {
			pre.add(cb.equal(bookRoot.join("productGroups").get("id"), productGroupId));
		}
		if(minPrice != null) {
			pre.add(cb.ge(bookRoot.get("sell_price"), minPrice));
		}
		if(maxPrice != null) {
			pre.add(cb.le(bookRoot.get("sell_price"), maxPrice));
		}
		if(genres != null) {
			if(!genres.isEmpty()) {
				pre.add(bookRoot.joinSet("genres").in(genres));
				cq.distinct(true);
			}
		}
		if(bookSetId != null) {
			pre.add(cb.equal(bookRoot.get("bookSet").get("id"), bookSetId));
		}
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Long> query = entityManager.createQuery(cq);
	    return query.getSingleResult();
	}
	
	public void merge(final Book book) {
		entityManager.merge(book);
	}
	
	public void delete(final Book book) {
	    entityManager.remove(book);
	}
	
	public BookDTO findByIdDTO(Long id) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getBookByID", "BookMapping")
				.registerStoredProcedureParameter("id", Long.class, ParameterMode.IN)
				.setParameter("id", id);
		return (BookDTO)query.getSingleResult();
	}
	
	
}
