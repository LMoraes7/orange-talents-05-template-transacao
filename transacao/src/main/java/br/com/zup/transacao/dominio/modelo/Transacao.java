package br.com.zup.transacao.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transacao {

	@Id
	private final String id;

	@Column(nullable = false)
	private final BigDecimal valor;

	@Embedded
	private final Estabelecimento estabelcimento;

	@JoinColumn(nullable = false)
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
	private final Cartao cartao;

	@Column(nullable = false, columnDefinition = "datetime")
	private final LocalDateTime efetivadaEm;

	public Transacao(String id, BigDecimal valor, Estabelecimento estabelcimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelcimento = estabelcimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartao == null) ? 0 : cartao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (cartao == null) {
			if (other.cartao != null)
				return false;
		} else if (!cartao.equals(other.cartao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", valor=" + valor + ", estabelcimento=" + estabelcimento + ", cartao=" + cartao
				+ ", efetivadaEm=" + efetivadaEm + "]";
	}
}