package com.algaworks.algafood.infrastructure.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Estado;

public class EstadoSpecs {

	public static Specification<Estado> comNomeSemelhante(String nome) {
		return (root, query, builder) ->
			builder.like(root.get("nome"), "%" + nome + "%");
	}
}
