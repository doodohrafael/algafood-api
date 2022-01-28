package com.algaworks.algafood.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeNaoRequisitadaCorretamente;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante buscar(Long id) {
		return restauranteRepository.porId(id);
	}
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com o código %d", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha);
		return restauranteRepository.adicionar(restaurante);
	}
	
	public Restaurante atualizar(Long restauranteId, Restaurante restaurante) {
		try {
			Restaurante restauranteAtual = restauranteRepository.porId(restauranteId);
			cozinhaRepository.buscar(restaurante.getCozinha().getId());
			if(restaurante.getCozinha().getId() == restauranteAtual.getCozinha().getId()) {
				BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
				cozinhaRepository.salvar(restauranteAtual.getCozinha());
			} else {
				BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "cozinha");
			}
			
			return restauranteRepository.adicionar(restauranteAtual);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoRequisitadaCorretamente(
					String.format("Não existe um cadastro de cozinha com código %d", restaurante.getCozinha().getId()));
		} catch (IllegalArgumentException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de restaurante com código %d", restauranteId));
		}

	}
	
	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.remover(restauranteId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoRequisitadaCorretamente(
					String.format("Não existe um cadastro de restaurante com código %d", restauranteId));
		}
	}
	
}
