package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

	List<Restaurante> findByNomeContaining(String nome);
	
	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNomeECozinha(String nome, 
			@Param("id") Long cozinhaId);
	
	List<Restaurante> readByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
}
