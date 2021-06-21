package br.com.zup.transacao.dominio.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cartao {

	@Id
	private String id;
	
	@Column(nullable = false)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cartao")
	private Set<Transacao> transacoes = new HashSet<Transacao>();
	
	public Cartao() {
	}

	public Cartao(String id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public void addTransacao(Transacao transacao) {
		this.transacoes.add(transacao);
	}
	
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Cartao other = (Cartao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + "]";
	}
}
