package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cidade) {
		try {
			return cadastroCidade.salvar(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{cidadeId}")
	public Cidade buscar(@PathVariable Long cidadeId) {
		return cadastroCidade.buscarOuFalhar(cidadeId);
	}

	@PutMapping("/{cidadeId}")
	public Cidade atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
		Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);
		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
		
		try {
			return cadastroCidade.salvar(cidadeAtual);
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long cidadeId) {
		cadastroCidade.excluir(cidadeId);
	}

	@PatchMapping("/{cidadeId}")
	public Cidade atualizarParcial(@PathVariable Long cidadeId,
			@RequestBody Map<String, Object> campos) {
		Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);
		merge(campos, cidadeAtual);
		
		return atualizar(cidadeId, cidadeAtual);
	}

	public void merge(Map<String, Object> dadosOrigem, Cidade cidadeDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Cidade cidadeOrigem = objectMapper.convertValue(dadosOrigem, Cidade.class);
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Cidade.class, nomePropriedade);
			field.setAccessible(true);
			Object novoValor = ReflectionUtils.getField(field, cidadeOrigem);
			ReflectionUtils.setField(field, cidadeDestino, novoValor);
			
		});
	}
	
	@GetMapping("/por-nome")
	public List<Cidade> cidadePorNome(String nome) {
		return cidadeRepository.cidadePorNome(nome);
	}
	
	@GetMapping("/por-nome-e-estado")
	public List<Cidade> cidadePorNomeEEstado(String nome, Long estadoId) {
		return cidadeRepository.findByNomeContainingAndEstadoId(nome, estadoId);
	}
	
	@GetMapping("/duas-primeiras")
	public List<Cidade> duasPrimeirasCidades() {
		return cidadeRepository.findTwo();
	}
	
	@GetMapping("/primeira")
	public Optional<Cidade> primeiraCidade() {
		return cidadeRepository.findFirst();
	}
	
	@GetMapping("/estados")
	public int cidadePorEstado(Long estadoId) {
		return cidadeRepository.countByEstadoId(estadoId);
	}
}
