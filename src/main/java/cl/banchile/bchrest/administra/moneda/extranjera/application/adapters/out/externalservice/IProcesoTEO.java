package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.out.externalservice;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.MonedaResponse;

/**
 * @author Pablo
 *
 */
public interface IProcesoTEO  {
    public MonedaResponse listadoMonedas();
    public MonedaResponse getPrecioByMoneda(String moneda);
}
