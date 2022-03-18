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

import com.hieu.backend.entity.ProductGroup;

@Repository(value = "productGroupDAO")
@Transactional(rollbackFor = Exception.class)
public class ProductGroupDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public ProductGroup findById(final Long id) {
	    return entityManager.find(ProductGroup.class, id);
	}
	
	public Long persist(final ProductGroup roductGroup) {
		entityManager.persist(roductGroup);
		return roductGroup.getId();
	}
	
	public List<ProductGroup> findAll(Long parent_id){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductGroup> cq = cb.createQuery(ProductGroup.class);
		Root<ProductGroup> root = cq.from(ProductGroup.class);
		cq.select(root);
		if(parent_id != null) {
			if(parent_id > 0) {
				cq.where(cb.equal(root.get("parent_group").get("id"), parent_id));
			}
			else {
				cq.where(root.get("parent_group").get("id").isNull());
			}
		}
		TypedQuery<ProductGroup> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	public Long count(Long parent_id){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<ProductGroup> root = cq.from(ProductGroup.class);
		cq.select(cb.count(root));
		if(parent_id != null) {
			if(parent_id > 0) {
				cq.where(cb.equal(root.get("parent_group").get("id"), parent_id));
			}
			else {
				cq.where(root.get("parent_group").get("id").isNull());
			}
		}
		TypedQuery<Long> query = entityManager.createQuery(cq);
		return query.getSingleResult();	
	}
}
