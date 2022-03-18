package com.hieu.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.dto.GenreDTO;
import com.hieu.backend.entity.Genre;

@Repository(value = "genreDAO")
@Transactional(rollbackFor = Exception.class)
public class GenreDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public Genre findById(final Long id) {
	    return entityManager.find(Genre.class, id);
	}
	
	public List<GenreDTO> findAllDTO(int offset, int limit) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getAllGenres", "GenreMapping");
		query.setFirstResult(offset);
		if(limit > 0) {
			query.setMaxResults(limit);
		}
	    return query.getResultList();
	}
	
	public Long persist(final Genre genre) {
		entityManager.persist(genre);
		return genre.getId();
	}
}
