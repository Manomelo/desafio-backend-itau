package backend.itau.desafio.controller;
import org.springframework.web.bind.annotation.RestController;

import backend.itau.desafio.dto.TransacaoRequest;
import backend.itau.desafio.model.Transacao;
import backend.itau.desafio.service.TransacaoService;
import jakarta.validation.Valid;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador REST para gerenciar transacoes
 */
@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransacaoService transacaoService;

    /**
     * Construtor que recebe um Objeto de servico de transacao
     * @param transacaoService Objeto de servico de transacao
     */
    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    /**
     * Cria uma transacao
     * @param request Os dados da transacao enviados no corpo da request
     * @return HTTP 201 caso os parametros da transacao sejam validos. HTTP 422 caso algum dos campos estejam vazio, o valor da transacao seja nulo ou menor que zero ou o horario da transacao seja no futuro.
     */
    @PostMapping
    public ResponseEntity<Void> createTransacao(@Valid @RequestBody TransacaoRequest request ){
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0){
            return ResponseEntity.unprocessableContent().build();
        }

        transacaoService.addTransacao(new Transacao(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Limpa todo o historico de transacoes
     * @return Codigo HTTP 201
     */
    @DeleteMapping
    public ResponseEntity<Void> clearTransacoes(){
        transacaoService.clearTransacoes();
        return ResponseEntity.ok().build();
    }
}
