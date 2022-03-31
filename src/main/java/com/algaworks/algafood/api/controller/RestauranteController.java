package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
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
	public Restaurante buscar(@PathVariable Long restauranteId) {
		return cadastroRestautante.buscarOuFalhar(restauranteId);
	}
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante adicionar(@RequestBody Restaurante restaurante) {
		try {
			return cadastroRestautante.salvar(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@PutMapping("/{restauranteId}")
	public Restaurante atualizar(@PathVariable Long restauranteId, 
			@RequestBody Restaurante restaurante) {
		Restaurante restauranteAtual = cadastroRestautante.buscarOuFalhar(restauranteId);
		BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco",
					"dataCadastro");
		try {
			return cadastroRestautante.salvar(restauranteAtual);
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{restauranteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long restauranteId) {
		cadastroRestautante.excluir(restauranteId);
	}
	
	@PatchMapping("/{restauranteId}")
	public Restaurante atualizarParcial(@PathVariable Long restauranteId, 
			@RequestBody Map<String, Object> campos){
		Restaurante restauranteAtual = cadastroRestautante.buscarOuFalhar(restauranteId);
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
	
	@GetMapping("/por-nome")
	public List<Restaurante> restaurantePorNome(String nome) {
		return restauranteRepository.findByNomeContaining(nome);
	}
	
	@GetMapping("/por-nome-e-cozinha")
	public List<Restaurante> restaurantePorNomeECozinha(String nome, Long cozinhaId){
		return restauranteRepository.consultarPorNomeECozinha(nome, cozinhaId);
	}
	
	@GetMapping("/por-taxa-frete-ordenado-por-nome")
	public List<Restaurante> restaurantesPorTaxaFreteOrdenadosPorNome(BigDecimal taxaInicial
			, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetweenOrderByNomeAsc(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/por-nome-e-cozinha-orm")
	public List<Restaurante> restaurantePorNomeECozinhaOrm(String nome, Long cozinhaId) {
		return restauranteRepository.consultarPorNomeECozinhaOrm(nome, cozinhaId);
	}
	
	@GetMapping("/por-nome-e-frete")
	public List<Restaurante> restaurantesPorNomeFrete(String nome, BigDecimal taxaInicial
			, BigDecimal taxaFinal) {
		return restauranteRepository.find(nome, taxaInicial, taxaFinal);
	}
	
	@GetMapping("/por-nome-e-frete-dinamico")
	public List<Restaurante> restaurantesPorNomeFreteDinamico(String nome, BigDecimal taxaInicial
			, BigDecimal taxaFinal) {
		return restauranteRepository.findDinamico(nome, taxaInicial, taxaFinal);
	}
	
	@GetMapping("/por-taxa-frete")
	public List<Restaurante> restaurantePorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
		return restauranteRepository.queryByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/existe")
	public boolean restauranteExiste(String nome) {
		return restauranteRepository.existsByNome(nome);
	}
	
	@GetMapping("/dois-primeiros")
	public List<Restaurante> doisPrimeirosRestaurantes(String nome) {
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/por-nome-e-frete-criteria")
	public List<Restaurante> restaurantesPorNomeFreteCriteria(String nome, BigDecimal taxaInicial
			, BigDecimal taxaFinal) {
		return restauranteRepository.findCriteria(nome, taxaInicial, taxaFinal);
	}
	
	@GetMapping("/por-nome-com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nome) {
		return restauranteRepository.findComFreteGratis(nome);
	}
	
	@GetMapping("/primeiro-por-nome")
	public Optional<Restaurante> primeiroRestaurante(String nome) {
		return restauranteRepository.findFirstByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas")
	public int cozinhasRestaurante(Long cozinhaId) {
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}
	
	@GetMapping("/primeiro")
	public Optional<Restaurante> primeiroRestaurante() {
		return restauranteRepository.findFirst();
	}
	
	@GetMapping("/dois-primeiros-custom")
	public List<Restaurante> doisPrimeirosRestaurantesCustom() {
		return restauranteRepository.findTwo();
	}
	
}
