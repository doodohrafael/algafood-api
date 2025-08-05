import static com.algaworks.algafood.util.ResourceUtils.getContentFromResource;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.util.DatabaseCleaner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "/application-test.properties")
public class CadastroRestaurantOLD {
	
	private static final String VIOLACAO_DE_REGRA_DE_NEGOCIO_PROBLEM_TYPE = "Violação de regra de negócio";

	private static final String DADOS_INVALIDOS_PROBLEM_TITLE = "Dados inválidos";
	
	private static final int RESTAURANTE_ID_INEXISTENTE = 150;
	
	private final static String RECURSO_NAO_ENCONTRADO_PROBLEM_TYPE = "Recurso não encontrado";

	@LocalServerPort
	private int port;
	
	private String jsonRestauranteCorreto;
	private String jsonRestauranteSemFrete;
	private String jsonRestauranteSemCozinha;
	private String jsonRestauranteComCozinhaInexistente;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	Restaurante burgerTopRestaurante;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@BeforeEach
	private void setUp() {
		RestAssured.port = this.port;
		RestAssured.basePath = "/restaurantes";
		enableLoggingOfRequestAndResponseIfValidationFails();
		jsonRestauranteCorreto = 
				getContentFromResource("/json/correto/restaurante-new-york-barbecue.json");
		jsonRestauranteSemFrete = 
				getContentFromResource("/json/incorreto/restaurante-new-york-barbecue-sem-frete.json");
		jsonRestauranteSemCozinha = 
				getContentFromResource("/json/incorreto/restaurante-new-york-barbecue-sem-cozinha.json");
		jsonRestauranteComCozinhaInexistente =
				getContentFromResource("/json/incorreto/restaurante-new-york-barbecue-com-cozinha-inexistente.json");
		
		databaseCleaner.clearTables();
		prepararDados();
	}
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarRestaurantes() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarStatus201_QuandoCadastrarRestaurante() {
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteCorreto)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void deveRetornarStatus400_QuandoCadastrarRestauranteSemTaxaFrete() {
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteSemFrete)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(DADOS_INVALIDOS_PROBLEM_TITLE));
	}
	
	@Test
	public void deveRetornarStatus400_QuandoCadastrarRestauranteSemCozinha() {
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteSemCozinha)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(DADOS_INVALIDOS_PROBLEM_TITLE));
	}
	
	@Test
	public void deveRetornarStatus400_QuandoCadastrarRestauranteComCozinhaInexistente() {
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteComCozinhaInexistente)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(VIOLACAO_DE_REGRA_DE_NEGOCIO_PROBLEM_TYPE));
	}
	
	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoConsultarRestauranteExistente() {
		given()
			.accept(ContentType.JSON)
			.pathParam("restauranteId", burgerTopRestaurante.getId())
		.when()
			.get("/{restauranteId}")
		.then()
			.body("nome", equalTo(burgerTopRestaurante.getNome()))
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarStatus404_QuandoConsultarRestauranteInexistente() {
		given()
			.accept(ContentType.JSON)
			.pathParam("restauranteId", RESTAURANTE_ID_INEXISTENTE)
		.when()
			.get("/{restauranteId}")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.body("title", equalTo(RECURSO_NAO_ENCONTRADO_PROBLEM_TYPE));
	}
	
	public void prepararDados() {
		Cozinha cozinhaBrasileira = new Cozinha();
		cozinhaBrasileira.setNome("Brasileira");
		cozinhaRepository.save(cozinhaBrasileira);
		
		Cozinha cozinhaEstadunidense = new Cozinha();
		cozinhaEstadunidense.setNome("Estadunidense");
		cozinhaRepository.save(cozinhaEstadunidense);
		
		burgerTopRestaurante = new Restaurante();
		burgerTopRestaurante.setCozinha(cozinhaEstadunidense);
		burgerTopRestaurante.setNome("Burger Top");
		burgerTopRestaurante.setTaxaFrete(new BigDecimal(5.20));
		restauranteRepository.save(burgerTopRestaurante);
	}
	
}
