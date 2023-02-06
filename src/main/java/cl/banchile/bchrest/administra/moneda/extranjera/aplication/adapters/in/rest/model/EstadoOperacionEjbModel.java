package cl.banchile.bchrest.administra.moneda.extranjera.aplication.adapters.in.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pablo
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoOperacionEjbModel {
    private String codigoOperacion;
    private String glosaOperacion;
}
