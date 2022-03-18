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

import com.hieu.backend.dto.CustomerSignInDTO;
import com.hieu.backend.entity.Customer;

@Repository(value = "customerDAO")
@Transactional(rollbackFor = Exception.class)
public class CustomerDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public Long persist(final Customer customer) {
		entityManager.persist(customer);
		return customer.getId();
	}
	
	public void merge(final Customer customer) {
		entityManager.merge(customer);
	}
	
	public Customer findById(final Long id) {
	    return entityManager.find(Customer.class, id);
	}
	
	public Long count(String phone) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(cb.count(root));
		List<Predicate> pre = new ArrayList<>();
		if(phone != null) {
			pre.add(cb.equal(root.get("phone"), phone));
		}
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Long> query = entityManager.createQuery(cq);
	    return query.getSingleResult();
	}
	
	public Long count(CustomerSignInDTO customerSignInDTO) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(cb.count(root));
		List<Predicate> pre = new ArrayList<>();
		pre.add(cb.or(cb.equal(root.get("phone"), customerSignInDTO.getPhoneOrEmail()), cb.equal(root.get("email"), customerSignInDTO.getPhoneOrEmail())));
		pre.add(cb.equal(root.get("password"), customerSignInDTO.getPassword()));
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Long> query = entityManager.createQuery(cq);
	    return query.getSingleResult();
	}
	
	public Customer signIn(CustomerSignInDTO customerSignInDTO) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		List<Predicate> pre = new ArrayList<>();
		pre.add(cb.or(cb.equal(root.get("phone"), customerSignInDTO.getPhoneOrEmail()), cb.equal(root.get("email"), customerSignInDTO.getPhoneOrEmail())));
		pre.add(cb.equal(root.get("password"), customerSignInDTO.getPassword()));
		cq.where(pre.toArray(new Predicate[pre.size()]));
		TypedQuery<Customer> query = entityManager.createQuery(cq);
	    return query.getSingleResult();
	}
}
