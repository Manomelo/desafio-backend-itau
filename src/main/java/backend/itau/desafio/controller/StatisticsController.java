package backend.itau.desafio.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.itau.desafio.dto.StatisticResponse;
import backend.itau.desafio.service.TransacaoService;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    
    private final TransacaoService transacaoService;

    public StatisticsController(TransacaoService transService){
        this.transacaoService = transService;
    }

    @GetMapping
    public ResponseEntity<StatisticResponse> getStatistics(){
        DoubleSummaryStatistics stats = transacaoService.getStatistics();

        return ResponseEntity.ok(new StatisticResponse(stats));
    }
}
