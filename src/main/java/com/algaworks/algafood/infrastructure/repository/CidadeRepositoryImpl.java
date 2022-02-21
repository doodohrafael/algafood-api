package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.CidadeRepositoryQueries;

import static com.algaworks.algafood.infrastructure.repository.specs.CidadeSpecs.*;

@Repository
public class CidadeRepositoryImpl implements CidadeRepositoryQueries{

	@Autowired @Lazy
	private CidadeRepository cidadeRepository;
	
	
	@Override
	public List<Cidade> cidadePorNome(String nome) {
		return cidadeRepository.findAll(porNome(nome));
	}
	
}
