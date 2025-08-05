import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import com.algaworks.algafood.AlgafoodApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;


@SpringBootTest(classes = AlgafoodApiApplication.class)
class CadastroCozinhaIntegrationIT {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		EntidadeEmUsoException exception = assertThrows(EntidadeEmUsoException.class, () -> {
			// cenário
			Long cozinhaId = 1L;
			
			// ação
			cadastroCozinha.excluir(cozinhaId);
		});
		exception.printStackTrace();
		// validação
		assertThatExceptionOfType(EntidadeEmUsoException.class);
	}

	@Test
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		CozinhaNaoEncontradaException exception = assertThrows(CozinhaNaoEncontradaException.class, () -> {
			Long cozinhaId = 10L;
			cadastroCozinha.excluir(cozinhaId);
		});
		exception.printStackTrace();
		assertThatExceptionOfType(CozinhaNaoEncontradaException.class);
	}

	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");

		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);

		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}

	@Test
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {

		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			// cenário
			Cozinha novaCozinha = new Cozinha();
			novaCozinha.setNome(null);
			
			// ação
			novaCozinha = cadastroCozinha.salvar(novaCozinha);
		});
		exception.printStackTrace();

	}

}
