package backend.itau.desafio.model;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
/**
 * Representa uma transação
 */
public class Transacao {

    /** Valor da transacao. */
    private double valor;

    /** Data e horario da transacao. */
    private OffsetDateTime dataHora;

    
}
