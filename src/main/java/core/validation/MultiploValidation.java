package core.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultiploValidation implements ConstraintValidator<Multiplo, Number>{
	
	/* Validação criada apenas para aprender como criar uma anotação com implementação customizada. */

	private int numeroMultiplo;
	
	@Override
	public void initialize(Multiplo constraintAnnotation) {
		this.numeroMultiplo = constraintAnnotation.numero();
	}
	
	@Override
	public boolean isValid(Number value, ConstraintValidatorContext context) {
		boolean valido = true;
		if (value != null) {
			var multiploDecimal = BigDecimal.valueOf(numeroMultiplo);
			var valueDecimal = BigDecimal.valueOf(value.doubleValue());
			var resto = valueDecimal.remainder(multiploDecimal);
			valido = BigDecimal.ZERO.compareTo(resto) == 0;
		}
		
		return valido;
	}

}
