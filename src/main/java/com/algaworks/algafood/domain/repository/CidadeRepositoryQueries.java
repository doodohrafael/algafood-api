package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepositoryQueries {
	
	List<Cidade> cidadePorNome(String nome);
}
