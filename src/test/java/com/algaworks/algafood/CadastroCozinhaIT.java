package com.algaworks.algafood;

import static com.algaworks.algafood.util.ResourceUtils.getContentFromResource;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaIT {
	

	@LocalServerPort
	private int port;
	
	private static final int COZINHA_ID_INEXISTENTE = 100;
	
	private Cozinha cozinhaEstadunidense;
	
	private int quantidadeCozinhasCadastradas;
	
	private String resourceJsonCorretoCozinhaChinesa;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@BeforeEach
	public void setUp() {
		enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";
		databaseCleaner.clearTables();
		prepararDados();
		resourceJsonCorretoCozinhaChinesa = getContentFromResource("/json/correto/cozinha-chinesa.json");
	}
	
	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {
		given()
			.body(resourceJsonCorretoCozinhaChinesa)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinha() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarQuantidadeCorretaDeCozinhas_QuandoConsultarCozinhas() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.body("", hasSize(quantidadeCozinhasCadastradas))
			.body("nome", hasItems("Estadunidense", "Tailandesa"));
	}
	
	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaExistente() {
		given()
			.accept(ContentType.JSON)
			.pathParam("cozinhaId", cozinhaEstadunidense.getId())
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("nome", equalTo(cozinhaEstadunidense.getNome()));
	}
	
	@Test
	public void deveRetornarStatus404_QuandoConsultarCozinhaInexistente() {
		given()
			.accept(ContentType.JSON)
			.pathParam("cozinhaId", COZINHA_ID_INEXISTENTE)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	public void prepararDados() {
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Estadunidense");
		cozinhaRepository.save(cozinha2);
		cozinhaEstadunidense = cozinha2;
		
		quantidadeCozinhasCadastradas = (int) cozinhaRepository.count();
	}

}
