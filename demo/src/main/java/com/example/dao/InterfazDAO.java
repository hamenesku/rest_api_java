package com.example.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Usuario;

@Configuration
public interface InterfazDAO extends JpaRepository<Usuario, Integer>{

	@Query(" from Usuario as usu where usu.edad > 28")
	public Iterable<Usuario> getMayor28();
	
	@Query(" from Usuario where edad > 30")
	public Iterable<Usuario> countMayores30();
	
	
	
}
