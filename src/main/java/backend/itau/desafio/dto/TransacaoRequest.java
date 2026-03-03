package backend.itau.desafio.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransacaoRequest {
    

    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public Double getValor(){
        return valor;
    }

    public OffsetDateTime getDataHora(){
        return dataHora;
    }
}
