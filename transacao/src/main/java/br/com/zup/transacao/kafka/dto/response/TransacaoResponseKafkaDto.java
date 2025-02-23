package br.com.zup.transacao.kafka.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.transacao.dominio.modelo.Transacao;

public class TransacaoResponseKafkaDto {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponseKafkaDto estabelcimento;
	private CartaoResponseKafkaDto cartao;
	private LocalDateTime efetivadaEm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EstabelecimentoResponseKafkaDto getEstabelcimento() {
		return estabelcimento;
	}

	public void setEstabelcimento(EstabelecimentoResponseKafkaDto estabelcimento) {
		this.estabelcimento = estabelcimento;
	}

	public CartaoResponseKafkaDto getCartao() {
		return cartao;
	}

	public void setCartao(CartaoResponseKafkaDto cartao) {
		this.cartao = cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public void setEfetivadaEm(LocalDateTime efetivadaEm) {
		this.efetivadaEm = efetivadaEm;
	}
	
	public Transacao toModel() {
		return new Transacao(id, valor, null, cartao.toModel(), efetivadaEm);
	}

	@Override
	public String toString() {
		return "EventoDeTransacao [id=" + id + ", valor=" + valor + ", estabelcimento=" + estabelcimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}
}
