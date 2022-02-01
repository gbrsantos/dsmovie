package com.projetos.dsmovie.config.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	
}
