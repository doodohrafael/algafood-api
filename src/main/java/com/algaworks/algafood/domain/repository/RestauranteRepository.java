package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries{

	List<Restaurante> findByNomeContaining(String nome);
	
	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNomeECozinha(String nome, 
			@Param("id") Long cozinhaId);
	
	List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	boolean existsByNome(String nome);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	Optional<Restaurante> findFirstByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinhaId);
	
	List<Restaurante> findByTaxaFreteBetweenOrderByNomeAsc(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	List<Restaurante> consultarPorNomeECozinhaOrm(String nome, @Param("id") Long cozinhaId);
	
	//List<Restaurante> find(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal);
	
}
