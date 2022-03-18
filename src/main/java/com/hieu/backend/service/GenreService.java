package com.hieu.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dao.GenreDAO;
import com.hieu.backend.dto.GenreDTO;
import com.hieu.backend.entity.Genre;

@Service
@Transactional
public class GenreService {
	@Autowired
	private GenreDAO genreDAO;
	
	public List<GenreDTO> findAllDTO(int offset, int limit){
		return genreDAO.findAllDTO(offset, limit);
	}
}
