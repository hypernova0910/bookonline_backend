package com.hieu.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.common.Constants;
import com.hieu.backend.dto.GenreDTO;
import com.hieu.backend.entity.Genre;
import com.hieu.backend.service.GenreService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("genre")
public class GenreController {
	@Autowired
	private GenreService genreService;
	
	@GetMapping("getAllDTO/{offset}/{limit}")
	public List<GenreDTO> getAll(@PathVariable int offset, @PathVariable int limit){
		return genreService.findAllDTO(offset, limit);
	}
}
