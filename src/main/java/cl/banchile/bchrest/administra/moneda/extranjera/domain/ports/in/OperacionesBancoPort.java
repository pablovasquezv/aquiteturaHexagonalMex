package cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.in;

import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;

/**
 * @author Pablo
 *
 */

public interface OperacionesBancoPort {
    public OperacionMonedaExtranjeraTO addOperacionMonedaExtranjeraIn(OperacionMonedaExtranjeraTO operacionMonedaExtranjeraTO);
}