package cl.banchile.bchrest.administra.moneda.extranjera;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.EstadoOperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionMonedaExtranjeraModel;
import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pablo
 *
 */

@Slf4j
public class Util {

    public static OperacionMonedaExtranjeraTO  jsonRequest()  {
        ObjectMapper objectMapper= new ObjectMapper();
        OperacionMonedaExtranjeraTO operacionMonedaExtranjeraTO = null;
        try {
            operacionMonedaExtranjeraTO = objectMapper.readValue(new File("src/test/resources/request.json"), OperacionMonedaExtranjeraTO.class);
        } catch (IOException e) {
            log.error("Ocurrio un error" + e);
        }
        return operacionMonedaExtranjeraTO;
    }

    public static OperacionMonedaExtranjeraTO jsonResponse()  {
        ObjectMapper objectMapper= new ObjectMapper();
        OperacionMonedaExtranjeraTO operacionMonedaExtranjeraTO = null;
        try {
            operacionMonedaExtranjeraTO = objectMapper.readValue(new File("src/test/resources/response.json"), OperacionMonedaExtranjeraTO.class);
        } catch (IOException e) {
            log.error("Ocurrio un error" + e);
        }
        return operacionMonedaExtranjeraTO;
    }

    public static OperacionMonedaExtranjeraModel jsonResponseModel()  {
        ObjectMapper objectMapper= new ObjectMapper();
        OperacionMonedaExtranjeraModel operacion = null;
        try {
            operacion = objectMapper.readValue(new File("src/test/resources/response.json"), OperacionMonedaExtranjeraModel.class);
        } catch (IOException e) {
            log.error("Ocurrio un error" + e);
        }
        return operacion;
    }

    public static OperacionInstruccionModel  jsonRequestMonexInstruccion()  {
        ObjectMapper objectMapper= new ObjectMapper();
        OperacionInstruccionModel operacionInstruccionModel = null;
        try {
            operacionInstruccionModel = objectMapper.readValue(new File("src/test/resources/requestIns.json"), OperacionInstruccionModel.class);
        } catch (IOException e) {
            log.error("Ocurrio un error" + e);
        }
        return operacionInstruccionModel;
    }

    public static EstadoOperacionInstruccionModel  jsonResponseMonexInstruccion()  {
        ObjectMapper objectMapper= new ObjectMapper();
        EstadoOperacionInstruccionModel estadoOperacionInstruccionModel = null;
        try {
            estadoOperacionInstruccionModel = objectMapper.readValue(new File("src/test/resources/responseIns.json"), EstadoOperacionInstruccionModel.class);
        } catch (IOException e) {
            log.error("Ocurrio un error" + e);
        }
        return estadoOperacionInstruccionModel;
    }
/**
 public static ModalidadModel mockModalidadModel(){
 ModalidadModel mod = new ModalidadModel();
 mod.setCodigoModalidad(Long.valueOf("1"));
 return mod;
 }*/
}