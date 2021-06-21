package br.com.zup.transacao.api.controller.transacao.dto.response;

import br.com.zup.transacao.dominio.modelo.Estabelecimento;

public class EstabelecimentoResponseDto {

	private String nome;
	private String cidade;
	private String endereco;

	public EstabelecimentoResponseDto(Estabelecimento estabelecimento) {
		this.nome = estabelecimento.getNome();
		this.cidade = estabelecimento.getCidade();
		this.endereco = estabelecimento.getEndereco();
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "EstabelecimentoResponseDto [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}
}