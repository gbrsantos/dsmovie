package com.projetos.dsmovie.config.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.dsmovie.entities.Movie;
import com.projetos.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
}
