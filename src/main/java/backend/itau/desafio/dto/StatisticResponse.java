package backend.itau.desafio.dto;

import java.util.DoubleSummaryStatistics;

import lombok.Getter;

/** DTO para transferir as estatisticas das transacoes para o cliente 
 * Utilizado no endpoint "/estatisticas"
*/
@Getter
public class StatisticResponse {
    
    /** Numero de transacoes observadas no periodo */
    private long count;
    /** Soma do valor das transacoes */
    private double sum;

    /** Media do valor das transacoes */
    private double avg;

    /** Valor da transacao de menor valor */
    private double min;

    /** Valor da transacao de maior valor */
    private double max;

    public StatisticResponse(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }
}
