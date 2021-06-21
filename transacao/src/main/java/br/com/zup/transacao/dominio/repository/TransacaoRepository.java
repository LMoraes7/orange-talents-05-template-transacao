package br.com.zup.transacao.dominio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.zup.transacao.dominio.modelo.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String>{

	@Query("SELECT t FROM Transacao t JOIN t.cartao c WHERE c.id = :id")
	Page<Transacao> consultarTransacoesPorCartao(@Param("id") String id, Pageable pageable);

}
