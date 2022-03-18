package com.hieu.backend.controller;

import java.util.List;

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
import com.hieu.backend.common.DataGrid;
import com.hieu.backend.common.SearchObject;
import com.hieu.backend.dto.BookDTO;
import com.hieu.backend.entity.Book;
import com.hieu.backend.service.BookService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("getOneById/{id}")
	public Book getOneById(@PathVariable Long id){
		return bookService.findById(id);
	}
	
//	@GetMapping("getAll/{offset}/{limit}")
//	public List<Book> getAll(@PathVariable int offset, @PathVariable int limit, 
//			@RequestParam(required = false) Long productGroupId){
//		return bookService.findAll(offset, limit, productGroupId);
//	}
	
	@GetMapping("getAllDataGrid/{curPage}/{limit}")
	public DataGrid getAllDataGrid(@PathVariable int curPage, @PathVariable int limit, 
			@RequestParam(required = false) Long productGroupId,
			@RequestParam(required = false) Double minPrice,
			@RequestParam(required = false) Double maxPrice,
			@RequestParam(required = false) List<Long> genres,
			@RequestParam(required = false) Long bookSetId,
			@RequestParam(required = false) String orderBy,
			@RequestParam(required = false) boolean isAsc
		){
		return bookService.findAllDataGrid(curPage, limit, 
			productGroupId,
			minPrice,
			maxPrice,
			genres,
			bookSetId,
			orderBy,
			isAsc
		);
	}
	
	@PostMapping("add")
	public Long add(@RequestBody Book book){
		return bookService.add(book);
	}
	
	@PostMapping("update")
	public void update(@RequestBody Book book){
		bookService.update(book);
	}
	
	@GetMapping("getOneByIdDTO/{id}")
	public BookDTO getOneByIdDTO(@PathVariable Long id){
		return bookService.findByIdDTO(id);
	}
}
