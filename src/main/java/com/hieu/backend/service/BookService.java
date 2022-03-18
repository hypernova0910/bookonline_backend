package com.hieu.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.common.DataGrid;
import com.hieu.backend.common.SearchObject;
import com.hieu.backend.dao.AuthorDAO;
import com.hieu.backend.dao.BookDAO;
import com.hieu.backend.dao.BookSetDAO;
import com.hieu.backend.dao.GenreDAO;
import com.hieu.backend.dao.ProductGroupDAO;
import com.hieu.backend.dto.BookDTO;
import com.hieu.backend.entity.Author;
import com.hieu.backend.entity.Book;
import com.hieu.backend.entity.BookSet;
import com.hieu.backend.entity.Genre;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private AuthorDAO authorDAO;
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private ProductGroupDAO productGroupDAO;
	
	public Book findById(final Long id) {
	    return bookDAO.findById(id);
	}
	
//	public List<Book> findAll(int offset, int limit, Long productGroupId) {
//	    return bookDAO.findAll(offset, limit, productGroupId);
//	}
	
	public BookDTO findByIdDTO(Long id) {
	    return bookDAO.findByIdDTO(id);
	}
	
	public DataGrid findAllDataGrid(int curPage, int limit, 
			Long productGroupId,
			Double minPrice,
			Double maxPrice,
			List<Long> genres,
			Long bookSetId,
			String orderBy,
			boolean isAsc
		) {
		int offset = (curPage - 1) * limit;
		DataGrid grid = new DataGrid();
		Long count = bookDAO.count(
			productGroupId,
			minPrice,
			maxPrice,
			genres,
			bookSetId
		);
		grid.setTotal(count);
		grid.setCurPage(curPage);
		grid.setData(new ArrayList<Book>());
		if(count > 0) {
			grid.setData(bookDAO.findAll(offset, limit, 
				productGroupId,
				minPrice,
				maxPrice,
				genres,
				bookSetId,
				orderBy,
				isAsc
			));
		}
		return grid;
	}
	
	public Long add(final Book book) {
		if(book.getGenres() != null) {
			book.getGenres().forEach((genre) -> {
				if(genre.getId() == null) {
					genreDAO.persist(genre);
				}
			});
		}
		if(book.getAuthors() != null) {
			book.getAuthors().forEach((author) -> {
				if(author.getId() == null) {
					authorDAO.persist(author);
				}
			});
		}
		if(book.getProductGroups() != null) {
			book.getProductGroups().forEach((productGroup) -> {
				if(productGroup.getId() == null) {
					productGroupDAO.persist(productGroup);
				}
			});
		}
		return bookDAO.persist(book);
	}
	
	public void update(final Book book) {
		if(book.getGenres() != null) {
			book.getGenres().forEach((genre) -> {
				if(genre.getId() == null) {
					genreDAO.persist(genre);
				}
			});
		}
		if(book.getAuthors() != null) {
			book.getAuthors().forEach((author) -> {
				if(author.getId() == null) {
					authorDAO.persist(author);
				}
			});
		}
		if(book.getProductGroups() != null) {
			book.getProductGroups().forEach((productGroup) -> {
				if(productGroup.getId() == null) {
					productGroupDAO.persist(productGroup);
				}
			});
		}
		bookDAO.merge(book);
	}
}
