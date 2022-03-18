package com.hieu.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dao.ProductGroupDAO;
import com.hieu.backend.entity.ProductGroup;

@Service
@Transactional
public class ProductGroupService {
	@Autowired
	private ProductGroupDAO productGroupDAO;
	
	public List<ProductGroup> findAll(Long parent_id){
		return productGroupDAO.findAll(parent_id);
	}
	
	public Long count(Long parent_id){
		return productGroupDAO.count(parent_id);
	}
}
