package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository extends CustomJpaRepository<Cidade, Long>, 
JpaSpecificationExecutor<Cidade>, CidadeRepositoryQueries {

	List<Cidade> findByNomeContaining(String nome);
	
	List<Cidade> findByNomeContainingAndEstadoId(String nome, Long estadoId);
	
	int countByEstadoId(Long estadoId);
}
