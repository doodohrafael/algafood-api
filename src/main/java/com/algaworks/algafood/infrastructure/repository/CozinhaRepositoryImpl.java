package com.algaworks.algafood.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.CozinhaRepositoryQueries;
import static com.algaworks.algafood.infrastructure.repository.specs.CozinhaSpecs.*;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepositoryQueries{

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired @Lazy
	private CozinhaRepository cozinhaRepository;
	
	@Override
	public List<Cozinha> find(String nome) {
		var jpql = "from Cozinha where nome like :nome";
		return manager.createQuery(jpql, Cozinha.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public List<Cozinha> findDinamico(String nome) {
		StringBuilder jpql = new StringBuilder();
		var parametros = new HashMap<String, Object>();
				
		jpql.append("from Cozinha where 0 = 0 ");
		
		if(StringUtils.hasLength(nome)) {
			jpql.append("and nome like :nome ");
			parametros.put("nome", "%" + nome + "%");
		}
		TypedQuery<Cozinha> query = manager.createQuery(jpql.toString(), Cozinha.class);
		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
		return query.getResultList();
	}

	@Override
	public List<Cozinha> findCriteria(String nome) {
		var builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cozinha> criteria = builder.createQuery(Cozinha.class);
		Root<Cozinha> root = criteria.from(Cozinha.class);
		var predicates = new ArrayList<Predicate>();
		
		if(StringUtils.hasLength(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}
		
		criteria.where(predicates.toArray(new Predicate[0]));
		TypedQuery<Cozinha> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

	@Override
	public List<Cozinha> comNomesSemelhantes(String nome) {
		return cozinhaRepository.findAll(comNomeSemelhante(nome));
	}
	
}
