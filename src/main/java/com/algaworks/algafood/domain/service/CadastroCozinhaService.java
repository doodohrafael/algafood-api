package com.algaworks.algafood.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoExcption;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.salvar(cozinha);
	}

	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.remover(cozinhaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoExcption(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso. ", cozinhaId));
		}

	}
	
	public Cozinha buscar(Long cozinhaId) {
		return cozinhaRepository.buscar(cozinhaId);
	}

	public Cozinha atualizar(Long cozinhaId, Cozinha cozinha) {
		try {
			Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			cozinhaRepository.salvar(cozinhaAtual);
			return cozinhaAtual;
		} catch (IllegalArgumentException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		}
		
	}
	
}
