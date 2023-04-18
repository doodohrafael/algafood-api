package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public Cozinha buscar(@PathVariable Long cozinhaId) {
		return cadastroCozinha.buscarOuFalhar(cozinhaId);
		
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody @Valid Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public Cozinha atualizar(@PathVariable Long cozinhaId, @RequestBody @Valid Cozinha cozinha) {
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		return cadastroCozinha.salvar(cozinhaAtual);
	}

	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cozinhaId) {
		 cadastroCozinha.excluir(cozinhaId);
	}
	
	@PatchMapping("/{cozinhaId}")
	public Cozinha atualizarParcial(@PathVariable Long cozinhaId, @RequestBody Map<String, Object> campos){
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
		merge(campos, cozinhaAtual);
		
		return atualizar(cozinhaId, cozinhaAtual);
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
	
	@GetMapping("/por-nome-customizada")
	public List<Cozinha> cozinhaPorNomeCustomizada(String nome) {
		return cozinhaRepository.consultarCozinhaPorNome(nome);
	}
	
	@GetMapping("/por-nome-orm")
	public List<Cozinha> cozinhaPorNomeOrm(String nome) {
		return cozinhaRepository.consultarCozinhaPorNomeOrm(nome);
	}
	
	@GetMapping("/por-nome-jpql")
	public List<Cozinha> cozinhaPorNomeJpql(String nome) {
		return cozinhaRepository.find(nome);
	}
	
	@GetMapping("/por-nome-dinamico")
	public List<Cozinha> cozinhaPorNomeDinamico(String nome) {
		return cozinhaRepository.findDinamico(nome);
	}
	
	@GetMapping("/por-nome-dois-primeiros")
	public List<Cozinha> cozinhaPorNomeDoisPrimeiros(String nome) {
		return cozinhaRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("por-nome-primeiro")
	public Optional<Cozinha> cozinhaPorNomePrimeiro(String nome) {
		return cozinhaRepository.findFirstByNomeContaining(nome);
	}
	
	@GetMapping("/por-nome-criteria")
	public List<Cozinha> cozinhaPorNomeCriteria(String nome) {
		return cozinhaRepository.findCriteria(nome);
	}
	
	@GetMapping("/duas-primeiras-custom")
	public List<Cozinha> duasPrimeirasCozinhasCustom() {
		return cozinhaRepository.findTwo();
	}
	
	@GetMapping("/nomes-semelhantes")
	public List<Cozinha> cozinhasNomesSemelhantes(String nome) {
		return cozinhaRepository.comNomesSemelhantes(nome);
	}
}
