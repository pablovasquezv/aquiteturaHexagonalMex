package cl.banchile.bchrest.administra.moneda.extranjera.aplication.adapters.in.rest.externalservice;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.MonedaResponse;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.PddTra;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.UniMon;

import cl.banchile.bchrest.administra.moneda.extranjera.common.utils.Utils;
import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out.RepositoryPddTra;
import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out.RepositoryUniMon;
import lombok.extern.log4j.Log4j2;

import oracle.jdbc.OracleDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class ProcesoTEOAdapter implements IProcesoTEO  {

    @Autowired
    private RepositoryUniMon repositoryUniMon;

    @Autowired
    private RepositoryPddTra repositoryPddTra;

    @Autowired
    private Utils utils;

    @Override
    public MonedaResponse listadoMonedas() {
        List<UniMon> listadoMonedas= new ArrayList<>();
        try {
            log.info("Inicio preoceso listadoMonedas");
            listadoMonedas = repositoryUniMon.listadoMonedas();
            if(listadoMonedas.isEmpty()){
                return new MonedaResponse(listadoMonedas, HttpStatus.NO_CONTENT);
            }
        }catch (RuntimeException ex){
            log.error(ex);
            return new MonedaResponse(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new MonedaResponse(listadoMonedas, HttpStatus.OK);
    }
    @Override
    public MonedaResponse getPrecioByMoneda(String moneda) {
        PddTra objPrecioMoneda = new PddTra();
        try {
            log.info("Inicio preoceso getPrecioByMoneda con valor {}",moneda);
            objPrecioMoneda = repositoryPddTra.getPrecioByMoneda(moneda);
            log.info("Salida preoceso getPrecioByMoneda");
            if(objPrecioMoneda == null){
                return new MonedaResponse(objPrecioMoneda, HttpStatus.NO_CONTENT);
            }
        }catch (RuntimeException ex){
            log.error(ex);
            return new MonedaResponse(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new MonedaResponse(objPrecioMoneda, HttpStatus.OK);
    }
}
