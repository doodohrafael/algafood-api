package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cidade> todas() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade porId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Cidade adicionar(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void remover(Long cidadeId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
