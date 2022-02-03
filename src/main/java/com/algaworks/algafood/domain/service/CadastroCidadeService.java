package com.algaworks.algafood.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	public Cidade adicionar(Cidade cidade) {
		Estado estado = estadoRepository.porId(cidade.getEstado().getId());
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o código %d", cidade.getEstado().getId()));
		}
		cidade = cidadeRepository.adicionar(cidade);
		return cidade;
	}
	
	public Cidade atualizar(Long cidadeId, Cidade cidade) {
		try {
			Cidade cidadeAtual = cidadeRepository.porId(cidadeId);
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
			cidade = cidadeRepository.adicionar(cidadeAtual);
			return cidadeAtual;
		} catch (IllegalArgumentException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o código %d", cidadeId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o código %d", cidade.getEstado().getId()));
		}
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.remover(cidadeId);
		} catch (IllegalArgumentException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o código %d", cidadeId));
		}
	}
	
}