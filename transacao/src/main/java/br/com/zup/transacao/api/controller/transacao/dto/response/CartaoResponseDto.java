package br.com.zup.transacao.api.controller.transacao.dto.response;

import br.com.zup.transacao.dominio.modelo.Cartao;

public class CartaoResponseDto {

	private String id;
	private String email;

	public CartaoResponseDto(Cartao cartao) {
		this.id = cartao.getId();
		this.email = cartao.getEmail();
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "CartaoResponseDto [id=" + id + ", email=" + email + "]";
	}
}