package com.projetos.dsmovie.config.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.dsmovie.entities.Movie;
import com.projetos.dsmovie.entities.Score;
import com.projetos.dsmovie.entities.ScorePK;
import com.projetos.dsmovie.entities.User;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

	
}
