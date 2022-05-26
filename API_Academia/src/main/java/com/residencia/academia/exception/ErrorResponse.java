package com.residencia.academia.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	private final int status;
	private final String mensagem;

	public ErrorResponse(int status, String mensagem) {
		super();
		this.status = status;
		this.mensagem = mensagem;
	}

	public int getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}
}
