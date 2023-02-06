package cl.banchile.bchrest.administra.moneda.extranjera.aplication.adapters.in.rest.model;

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
public class OperacionMonedaExtranjeraModel extends AbstractOperacionModel {
    private String canal;
    private String codigoOficina;
    private BigDecimal factorCalculoPreciosPuntas;
    private BigDecimal factorFijoParidad;
    private String indicadorCanalDeIngreso;
    private MonedaModel monedaCobroTO;
    private MonedaModel monedaPagoTO;
    private BigDecimal montoComisionCalculada;
    private BigDecimal montoComisionRealCalculada;
    private BigDecimal montoComisionRealSinIVA;
    private BigDecimal montoTotalPago;
    private String oficinaLiquidacion;
    private OrdenLiquidacionModel ordenLiquidacionTO;
    private BigDecimal paridad;
    private BigDecimal precioCompra;
    private BigDecimal precioMedio;
    private BigDecimal precioPunta;
    private BigDecimal precioVenta;
    private BigDecimal spreadAsociado;
}

