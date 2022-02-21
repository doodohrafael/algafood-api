package com.algaworks.algafood.infrastructure.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Cozinha;

public class CozinhaSpecs {

	public static Specification<Cozinha> comNomeSemelhante(String nome) {
		return (root, query, builder) -> builder.like(root.get("nome"), "%" + nome + "%");
	}

}
