package com.hieu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.common.Constants;
import com.hieu.backend.embeddable.CartBookKey;
import com.hieu.backend.service.CartBookService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("cartBook")
public class CartBookController {
	@Autowired
	private CartBookService cartBookService;
	
	@DeleteMapping("delete")
	public void delete(@RequestBody CartBookKey cartBookKey) {
		cartBookService.delete(cartBookKey);
	}
}
