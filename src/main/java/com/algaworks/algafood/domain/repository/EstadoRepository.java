package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>, CustomJpaRepository<Estado, Long>,
		JpaSpecificationExecutor<Estado>, EstadoRepositoryQueries {
	
	List<Estado> findByNomeStartingWith(String nome);
	
}
