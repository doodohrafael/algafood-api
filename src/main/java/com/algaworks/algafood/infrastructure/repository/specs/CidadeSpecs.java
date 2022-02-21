package com.algaworks.algafood.infrastructure.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Cidade;

public class CidadeSpecs {

	public static Specification<Cidade> porNome(String nome) {
		return (root, query, builder) -> 
			builder.like(root.get("nome"), "%" + nome + "%");
	}
	
}
