package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepositoryQueries {

	List<Cozinha> find(String nome);
	
	List<Cozinha> findDinamico(String nome);
	
	List<Cozinha> findCriteria(String nome);
	
	List<Cozinha> comNomesSemelhantes(String nome);
	
}
