package br.com.zup.transacao.dto.response;

import br.com.zup.transacao.dominio.modelo.Cartao;

public class CartaoResponseDto {

	private String id;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cartao toModel() {
		return new Cartao(id, email);
	}

	@Override
	public String toString() {
		return "CartaoResponseDto [id=" + id + ", email=" + email + "]";
	}
}
