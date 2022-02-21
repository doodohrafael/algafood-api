package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoExcption;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.findAll();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
		if (cozinha.isPresent()) {
			return ResponseEntity.ok(cozinha.get());
		}
		return ResponseEntity.notFound().build();
	}


	@PostMapping
	public ResponseEntity<Cozinha> adicionar(@RequestBody Cozinha cozinha) {
		cozinha = cadastroCozinha.salvar(cozinha);
		return ResponseEntity.status(HttpStatus.CREATED).body(cozinha);
	}

	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
			Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);
			if(cozinhaAtual.isPresent()) {
				BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
				cadastroCozinha.salvar(cozinhaAtual.get());
				return ResponseEntity.status(HttpStatus.OK).body(cozinhaAtual.get());
			}
			
			return ResponseEntity.notFound().build();
	}


	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<?> remover(@PathVariable Long cozinhaId) {
		try {
			cadastroCozinha.excluir(cozinhaId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoExcption e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@PatchMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizarParcial(@PathVariable Long cozinhaId, @RequestBody Map<String, Object> campos){
		Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);
		if(cozinhaAtual.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		merge(campos, cozinhaAtual.get());
		
		return atualizar(cozinhaId, cozinhaAtual.get());
	}
	
	private void merge(Map<String, Object> dadosOrigem, Cozinha cozinhaDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Cozinha cozinhaOrigem = objectMapper.convertValue(dadosOrigem, Cozinha.class);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Cozinha.class, nomePropriedade);
			field.setAccessible(true);
			Object novoValor = ReflectionUtils.getField(field, cozinhaOrigem);
			ReflectionUtils.setField(field, cozinhaDestino, novoValor);
		});
		
	}
	
	@GetMapping("/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome) {
		return cozinhaRepository.findByNomeContaining(nome);
	}
	
	@GetMapping("por-nome-customizada")
	public List<Cozinha> cozinhaPorNomeCustomizada(String nome) {
		return cozinhaRepository.consultarCozinhaPorNome(nome);
	}
	
	@GetMapping("por-nome-orm")
	public List<Cozinha> cozinhaPorNomeOrm(String nome) {
		return cozinhaRepository.consultarCozinhaPorNomeOrm(nome);
	}
	
	@GetMapping("por-nome-jpql")
	public List<Cozinha> cozinhaPorNomeJpql(String nome) {
		return cozinhaRepository.find(nome);
	}
	
	@GetMapping("por-nome-dinamico")
	public List<Cozinha> cozinhaPorNomeDinamico(String nome) {
		return cozinhaRepository.findDinamico(nome);
	}
	
	@GetMapping("por-nome-dois-primeiros")
	public List<Cozinha> cozinhaPorNomeDoisPrimeiros(String nome) {
		return cozinhaRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("por-nome-primeiro")
	public Optional<Cozinha> cozinhaPorNomePrimeiro(String nome) {
		return cozinhaRepository.findFirstByNomeContaining(nome);
	}
	
	@GetMapping("por-nome-criteria")
	public List<Cozinha> cozinhaPorNomeCriteria(String nome) {
		return cozinhaRepository.findCriteria(nome);
	}
}
