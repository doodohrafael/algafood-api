package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
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
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
		try {
			cidade = cadastroCidade.salvar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		if (cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
		Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
		if (cidadeAtual.isPresent()) {
			BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
			cidade = cadastroCidade.salvar(cidadeAtual.get());
			return ResponseEntity.ok(cidade);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> excluir(@PathVariable Long cidadeId) {
		try {
			cadastroCidade.excluir(cidadeId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PatchMapping("/{cidadeId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long cidadeId,
			@RequestBody Map<String, Object> campos) {
		Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
		if(cidadeAtual == null) {
			return ResponseEntity.notFound().build();
		}

		merge(campos, cidadeAtual.get());
		
		return atualizar(cidadeId, cidadeAtual.get());
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
