package com.algaworks.algafood.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoExcption;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado buscar(Long estadoId) {
		return estadoRepository.porId(estadoId);
	}

	public Estado salvar(Estado estado) {
		estado = estadoRepository.adicionar(estado);
		return estado;
	}

	public Estado atualizar(Long estadoId, Estado estado) {
		try {
			Estado estadoAtual = estadoRepository.porId(estadoId);
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			estadoRepository.adicionar(estadoAtual);
			return estadoAtual;
		} catch (IllegalArgumentException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com código %d", estadoId));
		}
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.remover(estadoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoExcption(
					String.format("Estado de código %d não pode ser removido, pois está em uso. ", estadoId));
		} catch (IllegalArgumentException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com código %d", estadoId));
		}
	}
}