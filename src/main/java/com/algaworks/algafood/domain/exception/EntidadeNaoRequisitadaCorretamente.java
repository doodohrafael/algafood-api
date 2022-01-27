package com.algaworks.algafood.domain.exception;

public class EntidadeNaoRequisitadaCorretamente extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntidadeNaoRequisitadaCorretamente(String msg) {
		super(msg);
	}
}
