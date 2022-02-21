package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long>, 
CozinhaRepositoryQueries{
	
	List<Cozinha> findTodasByNome(String nome);
	List<Cozinha> findByNomeContaining(String nome);
	
	@Query("from Cozinha where nome like %:nome%")
	List<Cozinha> consultarCozinhaPorNome(String nome);
	
	List<Cozinha> consultarCozinhaPorNomeOrm(String nome);
	
	List<Cozinha> findTop2ByNomeContaining(String nome);
	
	Optional<Cozinha> findFirstByNomeContaining(String nome);
}
