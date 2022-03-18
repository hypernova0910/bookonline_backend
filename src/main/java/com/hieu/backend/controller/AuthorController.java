package com.hieu.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.common.Constants;
import com.hieu.backend.entity.Author;
import com.hieu.backend.service.AuthorService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("getOneById/{id}")
	public Author getOneById(@PathVariable Long id){
		return authorService.findById(id);
	}
	
	@GetMapping("getAll/{offset}/{limit}")
	public List<Author> getAll(@PathVariable int offset, @PathVariable int limit){
		return authorService.findAll(offset, limit);
	}
	
	@PostMapping("add")
	public Long add(@RequestBody Author author){
		return authorService.add(author);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable Long id){
		authorService.delete(id);
	}
}
