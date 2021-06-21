package br.com.zup.transacao.kafka.evento;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.transacao.dominio.modelo.Transacao;
import br.com.zup.transacao.dominio.repository.TransacaoRepository;

@Component
public class ListenerDeTransacao {

	private TransacaoRepository transacaoRepository;

	public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@KafkaListener(topics = "${spring.kafka.topic.transactions}", groupId = "${spring.kafka.group-id.transactions}")
	@Transactional
	public void listener(EventoDeTransacao eventoTransacao) {
		Transacao transacao = eventoTransacao.toModel();
		transacao = this.transacaoRepository.save(transacao);
		System.out.println(transacao.toString());
	}
}