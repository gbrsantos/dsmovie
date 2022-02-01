package com.projetos.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetos.dsmovie.config.repositories.MovieRepository;
import com.projetos.dsmovie.dto.MovieDTO;
import com.projetos.dsmovie.entities.Movie;

@Service
public class MovieService {

	@Autowired 
	private MovieRepository repository;
	
	@Transactional (readOnly = true)
	public Page<MovieDTO> buscaTodos(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional (readOnly = true)
	public MovieDTO buscaUm(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
