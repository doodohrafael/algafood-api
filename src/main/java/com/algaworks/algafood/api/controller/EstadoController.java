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

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstado;

	@GetMapping("/{estadoId}")
	public Estado buscar(@PathVariable Long estadoId) {
		return cadastroEstado.buscarOuFalhar(estadoId);
	}
	
	@GetMapping
	public List<Estado> listar() {
		return estadoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar(@RequestBody @Valid Estado estado) {
		return cadastroEstado.salvar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public Estado atualizar(@PathVariable Long estadoId, @RequestBody @Valid Estado estado) {
		Estado estadoAtual = cadastroEstado.buscarOuFalhar(estadoId);
		BeanUtils.copyProperties(estado, estadoAtual, "id");
		return estadoRepository.save(estadoAtual);
	}
	
	@PatchMapping("/{estadoId}")
	public Estado atualizarParcial(@PathVariable Long estadoId,
			@RequestBody Map<String, Object> campos) {
		Estado estadoAtual = cadastroEstado.buscarOuFalhar(estadoId);
		merge(campos, estadoAtual);
		
		return atualizar(estadoId, estadoAtual);
	}

	public void merge(Map<String, Object> dadosOrigem, Estado estadoDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Estado estadoOrigem = objectMapper.convertValue(dadosOrigem, Estado.class);
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Estado.class, nomePropriedade);
			field.setAccessible(true);
			Object novoValor = ReflectionUtils.getField(field, estadoOrigem);
			ReflectionUtils.setField(field, estadoDestino, novoValor);
			
		});
	}
	
	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long estadoId) {
		cadastroEstado.excluir(estadoId);
	}
	
	@GetMapping("/quantidade")
	public long quantidade() {
		return estadoRepository.count();
	}
	
	@GetMapping("/por-nome")
	public List<Estado> nomesIguais(String nome) {
		return estadoRepository.comNomesIguais(nome);
	}
	
	@GetMapping("/primeiro")
	public Optional<Estado> primeiroEstado(String nome) {
		return estadoRepository.findFirst();
	}
	
	@GetMapping("/por-nome-comecando-por")
	public List<Estado> estadoPorNomeComecandoPor(String nome) {
		return estadoRepository.findByNomeStartingWith(nome);
	}
}
