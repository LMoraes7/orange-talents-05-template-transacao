package br.com.zup.transacao.kafka.evento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.transacao.dominio.modelo.Transacao;
import br.com.zup.transacao.kafka.dto.response.CartaoResponseKafkaDto;
import br.com.zup.transacao.kafka.dto.response.EstabelecimentoResponseKafkaDto;
import br.com.zup.transacao.kafka.dto.response.TransacaoResponseKafkaDto;

public class EventoDeTransacao {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponseKafkaDto estabelcimento;
	private CartaoResponseKafkaDto cartao;
	private LocalDateTime efetivadaEm;

	public EventoDeTransacao() {
	}
	
	public EventoDeTransacao(TransacaoResponseKafkaDto dto) {
		this.id = dto.getId();
		this.valor = dto.getValor();
		this.estabelcimento = dto.getEstabelcimento();
		this.cartao = dto.getCartao();
		this.efetivadaEm = dto.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponseKafkaDto getEstabelcimento() {
		return estabelcimento;
	}

	public CartaoResponseKafkaDto getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
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