package com.hieu.backend.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.common.Constants;
import com.hieu.backend.dto.CustomerSignInDTO;
import com.hieu.backend.entity.Cart;
import com.hieu.backend.entity.Customer;
import com.hieu.backend.service.CustomerService;

@CrossOrigin(origins = Constants.CROSS_ORIGIN, allowCredentials = "true")
@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("register")
	public Long register(@RequestBody Customer customer, HttpServletResponse response){
		Long id = customerService.register(customer);
		if(id > 0) {
			Cookie cookie = new Cookie("idCustomer", id.toString());
			cookie.setMaxAge(Constants.COOKIE_EXPIRY);
			response.addCookie(cookie);
		}
		return id;
	}
	
	@PostMapping("signIn")
	public Customer signIn(@RequestBody CustomerSignInDTO customerSignInDTO, HttpServletResponse response){
		Customer customer = customerService.signIn(customerSignInDTO);
		if(customer != null) {
			Cookie cookie = new Cookie("idCustomer", customer.getId().toString());
			cookie.setMaxAge(Constants.COOKIE_EXPIRY);
			response.addCookie(cookie);
		}
		return customer;
	}
	
	@GetMapping("/loggedId")
	public Long loggedId(@CookieValue(value = "idCustomer", defaultValue = "-1") String idST) {
		Long id = Long.parseLong(idST);
		return id;
	}
	
	@GetMapping("/removeCookie")
	public void removeCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("idCustomer", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	@GetMapping("/getOneById/{id}")
	public Customer getOneById(@PathVariable Long id) {
		return customerService.findById(id);
	}
	
//	@PostMapping("updateCart")
//	public void updateCart(Cart cart) {
//		
//	}
}
