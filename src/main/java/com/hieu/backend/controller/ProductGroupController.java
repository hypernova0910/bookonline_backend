package com.hieu.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.entity.ProductGroup;
import com.hieu.backend.service.ProductGroupService;
import com.hieu.backend.common.Constants;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("productGroup")
public class ProductGroupController {
	@Autowired
	private ProductGroupService productGroupService;
	
	@GetMapping("getAll")
	public List<ProductGroup> getAll(@RequestParam(required = false) Long parent_id){
		return productGroupService.findAll(parent_id);
	}
	
	@GetMapping("count")
	public Long count(@RequestParam(required = false) Long parent_id){
		return productGroupService.count(parent_id);
	}
}
