package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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

	public Cidade salvar(Cidade cidade) {
		Optional<Estado> estado = estadoRepository.findById(cidade.getEstado().getId());
		if (estado.isEmpty()) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com o código %d", cidade.getEstado().getId()));
		}
		cidade = cidadeRepository.save(cidade);
		return cidade;
	}

	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
		} catch (IllegalArgumentException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o código %d", cidadeId));
		} catch (InvalidDataAccessApiUsageException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o código %d", cidadeId));
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o código %d", cidadeId));
		}
	}
}
