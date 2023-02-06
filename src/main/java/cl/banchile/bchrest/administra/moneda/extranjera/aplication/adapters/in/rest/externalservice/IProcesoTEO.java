package cl.banchile.bchrest.administra.moneda.extranjera.aplication.adapters.in.rest.externalservice;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.MonedaResponse;

public interface IProcesoTEO  {
    public MonedaResponse listadoMonedas();
    public MonedaResponse getPrecioByMoneda(String moneda);
}
