package com.projetos.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.dsmovie.dto.MovieDTO;
import com.projetos.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	@Autowired
	private MovieService  movieService;

	@GetMapping
	public Page<MovieDTO> buscarTodos(Pageable pageable){
		return movieService.buscaTodos(pageable);
	}
	
	@GetMapping (value = "/{id}")
	public MovieDTO buscarPorId(@PathVariable Long id){
		return movieService.buscaUm(id);
	}
}
