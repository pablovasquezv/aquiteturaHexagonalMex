package cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionMonedaExtranjeraModel;
import cl.banchile.go.ejb.OperacionException_Exception;
import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Pablo
 *
 */

public interface OperacionBancoEJBPort {
    public OperacionMonedaExtranjeraModel agregarOperacionMonedaExtranjera(OperacionMonedaExtranjeraTO operacion) throws OperacionException_Exception, JsonProcessingException;
}