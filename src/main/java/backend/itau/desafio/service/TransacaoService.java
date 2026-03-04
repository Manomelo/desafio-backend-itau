package backend.itau.desafio.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import backend.itau.desafio.model.Transacao;

@Service
public class TransacaoService {

    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    /**
     * Recebe uma transação e a adiciona a lista de transações
     * 
     * @param trans Transação a ser adicionada
     */
    public void addTransacao(Transacao trans) {
        transacoes.add(trans);
    }

    /**
     * Limpa a lista de transações por inteiro
     * 
     * 
     */
    public void clearTransacoes() {
        transacoes.clear();
    }

    /**
     * Retorna estatisticas de todas as transações que ocorreram no último minuto
     * 
     * @return DoubleSummaryStatistics contendo contagem, soma, mínimo, máximo e média das transações válidadas pelo filtro
     */
    public DoubleSummaryStatistics getStatistics() {

        OffsetDateTime minusOneMinute = OffsetDateTime.now().minusMinutes(1);
        return transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(minusOneMinute))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

    }

}
