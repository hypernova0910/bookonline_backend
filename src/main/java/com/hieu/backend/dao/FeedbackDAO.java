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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dto.BookDTO;
import com.hieu.backend.dto.FeedbackStatistic;
import com.hieu.backend.entity.Feedback;

@Repository(value = "feedbackDAO")
@Transactional(rollbackFor = Exception.class)
public class FeedbackDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public Long persist(final Feedback feedback) {
		entityManager.persist(feedback);
		return feedback.getId();
	}
	
	public List<Feedback> findAll(int offset, int limit, Long book_id){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Feedback> cq = cb.createQuery(Feedback.class);
		Root<Feedback> root = cq.from(Feedback.class);
		List<Predicate> pre = new ArrayList<>();
		if(book_id != null) {
			pre.add(cb.equal(root.join("book").get("id"), book_id));
		}
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Feedback> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		if(limit > 0) {
			query.setMaxResults(limit);
		}
	    return query.getResultList();
	}
	
	public Long count(Long book_id){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Feedback> root = cq.from(Feedback.class);
		cq.select(cb.count(root));
		List<Predicate> pre = new ArrayList<>();
		if(book_id != null) {
			pre.add(cb.equal(root.join("book").get("id"), book_id));
		}
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Long> query = entityManager.createQuery(cq);
	    return query.getSingleResult();
	}
	
	public FeedbackStatistic statistic(Long book_id) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("feedbackStatistic", "FeedbackStatisticMapping")
				.registerStoredProcedureParameter("book_id", Long.class, ParameterMode.IN)
				.setParameter("book_id", book_id);
		return (FeedbackStatistic)query.getSingleResult();
	}
}
