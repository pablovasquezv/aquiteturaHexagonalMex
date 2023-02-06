package cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.EstadoOperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionInstruccionModel;

/**
 * @author Pablo
 *
 */

public interface OperacionInstruccionPagoEJBPort {
    public EstadoOperacionInstruccionModel agregarIsntruiccionPago(OperacionInstruccionModel op);
}