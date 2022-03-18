package com.hieu.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dao.AuthorDAO;
import com.hieu.backend.dao.BookSetDAO;
import com.hieu.backend.dao.GenreDAO;
import com.hieu.backend.entity.Author;
import com.hieu.backend.entity.BookSet;
import com.hieu.backend.entity.Genre;

@Service
@Transactional
public class BookSetService {
	@Autowired
	private BookSetDAO bookSetDAO;
	
	@Autowired
	private AuthorDAO authorDAO;
	
	@Autowired
	private GenreDAO genreDAO;
	
	public BookSet findById(final Long id) {
	    return bookSetDAO.findById(id);
	}
	
	public List<BookSet> findAll(int offset, int limit) {
	    return bookSetDAO.findAll(offset, limit);
	}
	
	public Long add(final BookSet bookSet) {
		if(bookSet.getGenres() != null) {
			bookSet.getGenres().forEach((genre) -> {
				if(genre.getId() == null) {
					genreDAO.persist(genre);
				}
			});
		}
		if(bookSet.getAuthors() != null) {
			bookSet.getAuthors().forEach((author) -> {
				if(author.getId() == null) {
					authorDAO.persist(author);
				}
			});
		}
		return bookSetDAO.persist(bookSet);
	}
	
	public void update(final BookSet bookSet) {
		if(bookSet.getGenres() != null) {
			bookSet.getGenres().forEach((genre) -> {
				if(genre.getId() == null) {
					genreDAO.persist(genre);
				}
			});
		}
		if(bookSet.getAuthors() != null) {
			bookSet.getAuthors().forEach((author) -> {
				if(author.getId() == null) {
					authorDAO.persist(author);
				}
			});
		}
		bookSetDAO.merge(bookSet);
	}
}
