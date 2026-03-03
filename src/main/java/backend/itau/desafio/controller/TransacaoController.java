package backend.itau.desafio.controller;
import org.springframework.web.bind.annotation.RestController;

import backend.itau.desafio.dto.TransacaoRequest;
import backend.itau.desafio.model.Transacao;
import backend.itau.desafio.service.TransacaoService;
import jakarta.validation.Valid;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransacao(@Valid @RequestBody TransacaoRequest request ){
        if(request.getDataHora().isAfter(OffsetDateTime.now())){
            return ResponseEntity.unprocessableContent().build();
        }

        transacaoService.addTransacao(new Transacao(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
