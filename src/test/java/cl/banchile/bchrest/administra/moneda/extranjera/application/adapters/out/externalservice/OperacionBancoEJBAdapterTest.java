package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.out.externalservice;

import cl.banchile.bchrest.administra.moneda.extranjera.Util;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.EstadoOperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionMonedaExtranjeraModel;
import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out.OperacionBancoEJBPort;
import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out.OperacionInstruccionPagoEJBPort;
import cl.banchile.go.ejb.OperacionException_Exception;
import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;
import cl.banchile.go.ejb.OperacionBancoEJB;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

/**
 * @author Pablo
 *
 */

@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
class OperacionBancoEJBAdapterTest {

    private OperacionMonedaExtranjeraTO requestObj, responseObj;

    private OperacionMonedaExtranjeraModel operacionMonedaExtranjeraModel, responseObjModel;

    private OperacionInstruccionModel operacionInstruccionModelReq;

    private EstadoOperacionInstruccionModel estadoOperacion;

    @Autowired
    private OperacionBancoEJBAdapter operacionBancoEJBAdapter;



    @Mock
    private OperacionBancoEJBPort operacionBancoEJBPort;



    @Mock
    private OperacionBancoEJB operacionBancoEJB;

    @Autowired
    private OperacionInstruccionPagoEJBAdapter instruccionAdapter;

    @Mock
    private OperacionInstruccionPagoEJBPort operacionInstruccionPagoEJBPort;

    @Test
    void agregarOperacionMonedaExtranjera() {
        log.info("Iniciando prueba addOperacionMonedaExtranjera");

        requestObj = Util.jsonRequest();
        responseObjModel = Util.jsonResponseModel();

        OperacionMonedaExtranjeraModel result = new OperacionMonedaExtranjeraModel();
        try {
            // Mockito.lenient().doReturn(responseObj).when(operacionBancoEJBPort).agregarOperacionMonedaExtranjera(requestObj);
            Mockito.when(operacionBancoEJBPort.agregarOperacionMonedaExtranjera(requestObj))
                    .thenReturn(responseObjModel);
            result = operacionBancoEJBPort.agregarOperacionMonedaExtranjera(requestObj);
            Assertions.assertEquals(responseObjModel.getIdTransaccion(), result.getIdTransaccion());
            log.info("Finalizando prueba addOperacionMonedaExtranjera");
        } catch (OperacionException_Exception e) {
            log.error("Ocurrio un error" + e);
        } catch (JsonProcessingException e) {
            log.error("Ocurrio un error" + e);
        }
    }

    @Test
    void adapterOperacionMonedaExtranjeraIntoOperacionMonedaExtranjeraTO() {

        log.info("Iniciando prueba addOperacionMonedaExtranjera");

        requestObj = Util.jsonRequest();
        responseObj = Util.jsonResponse();

        OperacionMonedaExtranjeraModel result = new OperacionMonedaExtranjeraModel();

        try {
            Mockito.lenient().doReturn(responseObj).when(operacionBancoEJB).addOperacionMonedaExtranjera(requestObj);
            result = operacionBancoEJBAdapter
                    .adapterOperacionMonedaExtranjeraIntoOperacionMonedaExtranjeraTO(requestObj);
            Assertions.assertEquals(responseObj.getIdTransaccion(), result.getIdTransaccion());
            log.info("Finalizando prueba  adapterOperacionMonedaExtranjeraIntoOperacionMonedaExtranjeraTO");
        } catch (OperacionException_Exception e) {
            log.error("Ocurrio un error" + e);
        }
    }
    @Test
    void adarterAgregaInstruccion() {
        log.info("Iniciando prueba instruccion ejb");


        operacionInstruccionModelReq = Util.jsonRequestMonexInstruccion();

        estadoOperacion = Util.jsonResponseMonexInstruccion();

        EstadoOperacionInstruccionModel instruccionState = EstadoOperacionInstruccionModel.builder().build();

        Mockito.when(operacionInstruccionPagoEJBPort.agregarIsntruiccionPago(operacionInstruccionModelReq)).thenReturn(estadoOperacion);
        instruccionState = operacionInstruccionPagoEJBPort.agregarIsntruiccionPago(operacionInstruccionModelReq);
        Assertions.assertEquals(instruccionState.getEstadoOperacion(),estadoOperacion.getEstadoOperacion());
        log.info("Finalizando prueba instruccion ejb");
    }
}