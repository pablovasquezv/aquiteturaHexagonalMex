package cl.banchile.bchrest.administra.moneda.extranjera.aplication.adapters.in.rest.externalservice;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionMonedaExtranjeraModel;
import cl.banchile.bchrest.administra.moneda.extranjera.common.utils.Utils;
import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out.OperacionBancoEJBPort;

import cl.banchile.go.ejb.OperacionBancoEJBService;
import cl.banchile.go.ejb.OperacionException_Exception;
import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Pablo
 *
 */
@Slf4j
@Service
public class OperacionBancoEJBAdapter implements OperacionBancoEJBPort {

    private OperacionBancoEJBService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Utils utils;

    public OperacionBancoEJBAdapter(@Value("${service.operacion-banco.url}") String url) {
        try {
            this.service = new OperacionBancoEJBService(new URL(url));
        } catch (MalformedURLException e) {
            log.error("Error: " + e);
        }
    }

    @Override
    public OperacionMonedaExtranjeraModel agregarOperacionMonedaExtranjera(OperacionMonedaExtranjeraTO operacion) {

        OperacionMonedaExtranjeraModel respuesta = new OperacionMonedaExtranjeraModel();
        try {
            log.info("------Inicio de método agregarOperacionMonedaExtranjera------");
            log.info("Entrada OperacionMonedaExtranjeraModel -> " + utils.imprimirLogsEntrada(operacion));
            respuesta = adapterOperacionMonedaExtranjeraIntoOperacionMonedaExtranjeraTO(service.getOperacionBancoEJBPort().addOperacionMonedaExtranjera(operacion));
            log.info("Salida OperacionMonedaExtranjera -> " + utils.imprimirLogsSalida(respuesta));
        } catch (OperacionException_Exception e) {
            log.error("Ocurrio un error" + e);
        }

        return respuesta;
    }

    public OperacionMonedaExtranjeraModel adapterOperacionMonedaExtranjeraIntoOperacionMonedaExtranjeraTO(OperacionMonedaExtranjeraTO operacion) {

        OperacionMonedaExtranjeraModel respuesta = new OperacionMonedaExtranjeraModel();
        String jsonResponse = null;
        try {
            jsonResponse = objectMapper.writeValueAsString(operacion);
            respuesta = objectMapper.readValue(jsonResponse, OperacionMonedaExtranjeraModel.class);
        } catch (JsonProcessingException e) {
            log.error("Ocurrio un error" + e);
        }

        return respuesta;
    }

}