package com.hieu.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.service.BookSetService;
import com.hieu.backend.common.Constants;
import com.hieu.backend.entity.BookSet;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("bookset")
public class BookSetController {
	@Autowired
	private BookSetService bookSetService;
	
	@GetMapping("getOneById/{id}")
	public BookSet getOneById(@PathVariable Long id){
		return bookSetService.findById(id);
	}
	
	@GetMapping("getAll/{offset}/{limit}")
	public List<BookSet> getAll(@PathVariable int offset, @PathVariable int limit){
		return bookSetService.findAll(offset, limit);
	}
	
	@PostMapping("add")
	public Long add(@RequestBody BookSet bookSet){
		return bookSetService.add(bookSet);
	}
	
	@PostMapping("update")
	public void update(@RequestBody BookSet bookSet){
		bookSetService.update(bookSet);
	}
}
