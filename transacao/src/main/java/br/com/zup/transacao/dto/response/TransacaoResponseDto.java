package br.com.zup.transacao.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.transacao.dominio.modelo.Transacao;

public class TransacaoResponseDto {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponseDto estabelcimento;
	private CartaoResponseDto cartao;
	private LocalDateTime efetivadaEm;

	public void setId(String id) {
		this.id = id;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setEstabelcimento(EstabelecimentoResponseDto estabelcimento) {
		this.estabelcimento = estabelcimento;
	}

	public void setCartao(CartaoResponseDto cartao) {
		this.cartao = cartao;
	}

	public void setEfetivadaEm(LocalDateTime efetivadaEm) {
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponseDto getEstabelcimento() {
		return estabelcimento;
	}

	public CartaoResponseDto getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Transacao toModel() {
		return new Transacao(id, valor, estabelcimento.toModel(), cartao.toModel(), efetivadaEm);
	}

	@Override
	public String toString() {
		return "TransacaoResponseDto [id=" + id + ", valor=" + valor + ", estabelcimento=" + estabelcimento
				+ ", cartao=" + cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
}
