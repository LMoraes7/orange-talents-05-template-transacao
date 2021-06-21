package br.com.zup.transacao.api.controller.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacao.api.controller.transacao.dto.response.TransacaoResponseDto;
import br.com.zup.transacao.dominio.modelo.Transacao;
import br.com.zup.transacao.dominio.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	private TransacaoRepository transacaoRepository;

	public TransacaoController(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@GetMapping("/cartao/{id}")
	public ResponseEntity<Page<TransacaoResponseDto>> consultarTransacoes(@PathVariable("id") String id,
			@PageableDefault(direction = Direction.DESC, page = 0, size = 10, sort = "efetivadaEm") Pageable pageable) {
		Page<Transacao> transacoes = this.transacaoRepository.consultarTransacoesPorCartao(id, pageable);
		if(!transacoes.isEmpty())
			return ResponseEntity.ok(TransacaoResponseDto.toCollection(transacoes));
		return ResponseEntity.notFound().build();
	}
}
