package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem Incompreensível"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido");
	
	private String uri;
	private String title;
	
	
	private ProblemType(String path, String title) {
		uri = "https//algafood.com.br" + path;
		this.title = title;
	}
}
