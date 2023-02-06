package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Pablo
 *
 */

@Data
@AllArgsConstructor
public class MonedaResponse {
    private Object response;
    private HttpStatus status;
}


