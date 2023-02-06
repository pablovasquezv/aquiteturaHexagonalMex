package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Pablo
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonedaModel {
    private Integer cantidadDEcimales;
    private String codigoIso;
    private String codigoMoneda;
    private String codigoMonedaSbif;
    private BigDecimal codigoMonedaSii;
    private String descripcionMoneda;
    private String simboloMoneda;
    private String tipoMoneda;
}
