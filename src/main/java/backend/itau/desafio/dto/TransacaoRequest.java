package backend.itau.desafio.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;


/**
 * DTO para requests de transacao. Utilizado no endpoint "/transacao"
 */
public class TransacaoRequest {
    

    /**
     * Valor da transação. Não pode ser nulo.
     */
    @NotNull
    private Double valor;

    /**
     * Horario e data da transacao. Nao pode ser nulo
     */
    @NotNull
    private OffsetDateTime dataHora;

    public Double getValor(){
        return valor;
    }

    public OffsetDateTime getDataHora(){
        return dataHora;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public void setDataHora(OffsetDateTime dataHora){
        this.dataHora = dataHora;
    }
}
