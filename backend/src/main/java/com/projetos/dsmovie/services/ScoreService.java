package com.projetos.dsmovie.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetos.dsmovie.config.repositories.MovieRepository;
import com.projetos.dsmovie.config.repositories.ScoreRepository;
import com.projetos.dsmovie.config.repositories.UserRepository;
import com.projetos.dsmovie.dto.MovieDTO;
import com.projetos.dsmovie.dto.ScoreDTO;
import com.projetos.dsmovie.entities.Movie;
import com.projetos.dsmovie.entities.Score;
import com.projetos.dsmovie.entities.User;

@Service
public class ScoreService {

	@Autowired 
	private MovieRepository movieRepository;
	
	@Autowired 
	private ScoreRepository scoreRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Transactional
	public MovieDTO salvarScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);	
		double sum = 0.0;
		for(Score s:movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.saveAndFlush(movie);
		
		return new MovieDTO(movie);
	}
	
	
}
