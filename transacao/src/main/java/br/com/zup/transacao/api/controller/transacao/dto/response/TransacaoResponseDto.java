package br.com.zup.transacao.api.controller.transacao.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.zup.transacao.dominio.modelo.Transacao;

public class TransacaoResponseDto {

	public static Page<TransacaoResponseDto> toCollection(Page<Transacao> transacoes) {
		return transacoes.map(TransacaoResponseDto::new);
	}

	private String id;
	private BigDecimal valor;
	private LocalDateTime efetivadaEm;

	public TransacaoResponseDto(Transacao transacao) {
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "TransacaoResponseDto [id=" + id + ", valor=" + valor + ", efetivadaEm=" + efetivadaEm + "]";
	}
}
