package com.hieu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.common.Constants;
import com.hieu.backend.entity.Cart;
import com.hieu.backend.service.CartService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("getOneById/{id}")
	public Cart getOneById(@PathVariable Long id){
		return cartService.findById(id);
	}
	
	@PostMapping("add")
	public Long add(@RequestBody Cart cart){
		return cartService.add(cart);
	}
	
	@PostMapping("update")
	public void update(@RequestBody Cart cart){
		cartService.update(cart);
	}
	
	@GetMapping("getCartByCustomerId")
	public Cart getCartByCustomerId(@RequestParam Long customerId) {
		return cartService.getCartByCustomerId(customerId);
	}
}
