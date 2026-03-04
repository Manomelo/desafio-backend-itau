package backend.itau.desafio.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.itau.desafio.dto.StatisticResponse;
import backend.itau.desafio.service.TransacaoService;

/**
 * Controlador REST para obter as estatisticas das transacoes que ocorreram no ultimo minuto
 */
@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    
    private final TransacaoService transacaoService;

    /**
     * Construtor do controlador
     * @param transService Servico de Transacoes
     */
    public StatisticsController(TransacaoService transService){
        this.transacaoService = transService;
    }

    /**
     * Recupera as estatatisticas de todas as transacoes que occoreram no ultimo minuto
     * @return DoubleSummaryStatistics contendo o count, sum, min, max e avg de todas as transacoes.
     */
    @GetMapping
    public ResponseEntity<StatisticResponse> getStatistics(){
        DoubleSummaryStatistics stats = transacaoService.getStatistics();

        return ResponseEntity.ok(new StatisticResponse(stats));
    }
}
