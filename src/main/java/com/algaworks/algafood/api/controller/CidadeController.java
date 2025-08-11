package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/cidades")
public class CidadeController {

	private final CidadeRepository cidadeRepository;
	private final CadastroCidadeService cadastroCidade;
	
	@GetMapping("/{cidadeId}")
	public Cidade buscar(@PathVariable Long cidadeId) {
		return cadastroCidade.buscarOuFalhar(cidadeId);
	}

	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody @Valid Cidade cidade) {
		try {
			return cadastroCidade.salvar(cidade);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{cidadeId}")
	public Cidade atualizar(@PathVariable Long cidadeId, @RequestBody @Valid Cidade cidade) {
		try {
			Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
			
			return cadastroCidade.salvar(cidadeAtual);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
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
	
	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long cidadeId) {
		cadastroCidade.excluir(cidadeId);
	}
	
	@GetMapping("/por-nome")
	public List<Cidade> cidadePorNome(String nome) {
		return cidadeRepository.cidadePorNome(nome);
	}
	
	@GetMapping("/primeira")
	public Optional<Cidade> primeiraCidade() {
		return cidadeRepository.findFirst();
	}
	
	@GetMapping("/por-nome-e-estado")
	public List<Cidade> cidadePorNomeEEstado(String nome, Long estadoId) {
		return cidadeRepository.findByNomeContainingAndEstadoId(nome, estadoId);
	}
	
	@GetMapping("/duas-primeiras")
	public List<Cidade> duasPrimeirasCidades() {
		return cidadeRepository.findTwo();
	}
	
	@GetMapping("/estados")
	public int cidadePorEstado(Long estadoId) {
		return cidadeRepository.countByEstadoId(estadoId);
	}
	
}