package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model;

import java.util.List;

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
public class OperacionInstruccionModel {


    private String canalOperacion;

    private Integer rutCliente;

    private Integer identificadorBeneficiario;

    private Integer numeroOrden;

    private Integer numeroInstruccionPago;

    private Integer numeroOperacion;

    private String producto;

    private String idTransaccion;

    private String observacion;

    private List<RequestEntryParam> parametros;


}
