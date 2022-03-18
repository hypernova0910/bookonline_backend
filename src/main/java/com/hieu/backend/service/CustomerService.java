package com.hieu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dao.CartDAO;
import com.hieu.backend.dao.CustomerDAO;
import com.hieu.backend.dto.CustomerSignInDTO;
import com.hieu.backend.entity.Cart;
import com.hieu.backend.entity.Customer;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	public Customer findById(final Long id) {
		return customerDAO.findById(id);
	}
	
	public Long register(final Customer customer) {
		if(customerDAO.count(customer.getPhone()) == 0) {
			return customerDAO.persist(customer);
		}
		else {
			return -1L;
		}
	}
	
	public Customer signIn(CustomerSignInDTO customerSignInDTO) {
		if(customerDAO.count(customerSignInDTO) > 0) {
			return customerDAO.signIn(customerSignInDTO);
		}
		return null;
	}
	
//	public void updateCart(Cart cart) {
//		Customer customer = customerDAO.findById(cart.getCustomer().getId());
//		if(cart.getId() == null) {
//			cartDAO.persist(customer.getCart());
//		}
//		customer.setCart(cart);
//		customerDAO.merge(customer);
//	}
}
