package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * @author Pablo
 *
 */

@Data
@Builder
public class RequestEntryParam {
    private String name;
    private String stringData;
    private LocalDateTime dateData;
    private BigDecimal numberData;
}
