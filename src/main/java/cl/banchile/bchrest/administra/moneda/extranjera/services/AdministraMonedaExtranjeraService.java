package cl.banchile.bchrest.administra.moneda.extranjera.services;

import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out.OperacionBancoEJBPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pablo
 *
 */

@Slf4j
@Service
public class AdministraMonedaExtranjeraService {
    @Autowired
    private OperacionBancoEJBPort out;
     /*
    @Override
    public OperacionMonedaExtranjeraTO addOperacionMonedaExtranjeraIn(OperacionMonedaExtranjeraTO operacion) {
        OperacionMonedaExtranjeraTO opx = null;
        try {
            opx = out.addOperacionMonedaExtranjera(operacion);
        } catch (OperacionException_Exception e) {
            log.error("Ocurrio un error"+e);
        }
        return opx;
    }*/
}