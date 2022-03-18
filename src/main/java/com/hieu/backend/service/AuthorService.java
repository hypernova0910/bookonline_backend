package com.hieu.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dao.AuthorDAO;
import com.hieu.backend.entity.Author;

@Service
@Transactional
public class AuthorService {
	@Autowired
	private AuthorDAO authorDAO;
	
	public Author findById(final Long id) {
	    return authorDAO.findById(id);
	}

	public List<Author> findAll(int offset, int limit) {
		return authorDAO.findAll(offset, limit);
	}
	
	public Long add(final Author author) {
		return authorDAO.persist(author);
	}
	
	public void delete(Long id) {
		Author author = authorDAO.findById(id);
		authorDAO.remove(author);
	}
}
