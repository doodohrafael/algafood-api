package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeEmUsoExcption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoExcption(String msg) {
		super(msg);
	}
	
}
