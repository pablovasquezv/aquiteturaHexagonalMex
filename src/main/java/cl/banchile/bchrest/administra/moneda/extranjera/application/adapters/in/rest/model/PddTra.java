package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Pablo
 *
 */

@Entity()
@Data
public class PddTra {
    @Id
    @Column(name ="codigomoneda")
    private String codigoMoneda;
    @Column(name ="simbolomoneda")
    private String simboloMoneda;
    @Column(name="paridadcompra")
    private Float paridadCompra;
    @Column(name="paridadventa")
    private Float paridadVenta;
    @Column(name="tipodecambiocompra")
    private Float tipoCambioCompra;
    @Column(name="tipodecambioventa")
    private Float tipoCambioVenta;

}
