package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeNaoRequisitadaCorretamente;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private CadastroRestauranteService cadastroRestautante;
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = cadastroRestautante.buscar(restauranteId);
		if(restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.todos();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante){
		try {
			restaurante = cadastroRestautante.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestautante.atualizar(restauranteId, restaurante);
			return ResponseEntity.ok().body(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			//return ResponseEntity.notFound().build();
		} catch (EntidadeNaoRequisitadaCorretamente e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<?> remover(@PathVariable Long restauranteId){
		try {
			cadastroRestautante.excluir(restauranteId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoRequisitadaCorretamente e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, 
			@RequestBody Map<String, Object> campos){
		Restaurante restauranteAtual = restauranteRepository.porId(restauranteId);
		if(restauranteAtual == null) {
			return ResponseEntity.notFound().build();
		}
		
		merge(campos, restauranteAtual);
		return atualizar(restauranteId, restauranteAtual);
	}
	
	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
			
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}
}
