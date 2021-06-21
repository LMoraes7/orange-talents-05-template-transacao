package br.com.zup.transacao.dominio.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {

	@Id
	private final String id;
	private String email;

	public Cartao(String id, String email) {
		this.id = id;
		this.email = email;
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
