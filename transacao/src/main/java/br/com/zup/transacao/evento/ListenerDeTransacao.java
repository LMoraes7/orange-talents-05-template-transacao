package br.com.zup.transacao.evento;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.dto.response.EventoDeTransacao;

@Component
public class ListenerDeTransacao {

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void ouvir(EventoDeTransacao eventoDeTransacao) {
		System.out.println(eventoDeTransacao.toString());
	}
}
