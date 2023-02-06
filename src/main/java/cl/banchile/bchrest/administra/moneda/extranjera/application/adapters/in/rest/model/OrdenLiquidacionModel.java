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
public class OrdenLiquidacionModel {
    private String codigoMonedaArbitraje;
    private String codigoMonedaCobro;
    private String codigoMonedaPago;
    private String codigoMotivoLiquidacion;
    private String codigoOficina;
    private String codigoOperacion;
    private String codigoProducto;
    private String codigoTipoCuenta;
    private String codigounidadJerarquia;
    private Integer correlativoMercado;
    private String estadoOrden;
    private Object fechaAnulacion;
    private Object fechaAnulacionOrden;
    private Object fechaCapturaOrden;
    private Object fechaIngresoOperacion;
    private Object fechaLiquidacion;
    private Object fechaLiquidacionRequerida;
    private Object fechaModificacion;
    private Object fechaRechazo;
    private String formaLiquidacion;
    private String indicadorAfectaPosicion;
    private String indicadorNeteo;
    private String indicadorOrdenAutorizada;
    private String indicadorOrdenLiquidada;
    private BigDecimal montoAutorizado;
    private BigDecimal montoPendienteCobro;
    private BigDecimal montoPendienteComision;
    private BigDecimal montoPendienteLiquidacion;
    private BigDecimal montoTotalCobro;
    private BigDecimal montoTotalComision;
    private BigDecimal montoTotalPago;
    private Long numeroMovimietoCuentaCorriente;
    private Long numeroOperacionProducto;
    private Long numeroOrden;
    private String observacionOrden;
    private String ordenBanco;
    private String rutCliente;
    private String rutEmpleadoIngresa;
    private String rutEmpleadoModifica;
    private Integer subRutCliente;
    private String tipoIngreso;
    private String tlEmpBchCodEmp;
    private String usuarioAnulaOrden;
    private String usuarioAutorizador;
}
