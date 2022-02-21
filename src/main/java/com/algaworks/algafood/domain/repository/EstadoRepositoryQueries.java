package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepositoryQueries {
	
	List<Estado> comNomesIguais(String nome);
	
}
