package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.repository.EstadoRepositoryQueries;
import static com.algaworks.algafood.infrastructure.repository.specs.EstadoSpecs.*;

@Repository
public class EstadoRepositoryImpl implements EstadoRepositoryQueries{

	@Autowired @Lazy
	private EstadoRepository estadoRepository;
	
	@Override
	public List<Estado> comNomesIguais(String nome) {
		return estadoRepository.findAll(comNomeSemelhante(nome));
	}
	
}
