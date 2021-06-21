package br.com.zup.transacao.dto.response;

import br.com.zup.transacao.dominio.modelo.Estabelecimento;

public class EstabelecimentoResponseDto {

	private String nome;
	private String cidade;
	private String endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Estabelecimento toModel() {
		return new Estabelecimento(nome, cidade, endereco);
	}

	@Override
	public String toString() {
		return "EstabelecimentoResponseDto [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}
}
