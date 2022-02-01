package com.projetos.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.dsmovie.dto.MovieDTO;
import com.projetos.dsmovie.dto.ScoreDTO;
import com.projetos.dsmovie.services.MovieService;
import com.projetos.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private MovieService  movieService;
	
	@Autowired
	private ScoreService  scoreService;

	
	
	@PutMapping
	public MovieDTO salvarScore(@RequestBody ScoreDTO dto){
		MovieDTO movieDTO = scoreService.salvarScore(dto);
		return movieDTO;
	}
}
