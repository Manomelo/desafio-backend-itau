package backend.itau.desafio.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import backend.itau.desafio.model.Transacao;

@Service
public class TransacaoService {
    
    // Estrutura de dados para lidar com transacoes simultaneas
    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    public void addTransacao(Transacao trans){
        transacoes.add(trans);
    }

    public void clearTransacoes(){
        transacoes.clear();
    }

    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime now = OffsetDateTime.now();
        return transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

    }
}
