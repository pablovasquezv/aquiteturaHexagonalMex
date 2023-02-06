package cl.banchile.bchrest.administra.moneda.extranjera.common.utils;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionMonedaExtranjeraModel;
import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

@Component
@Slf4j
public class Utils {
    @Autowired
    private ObjectMapper objectMapper;

    public static String getMethodName() {

        if (Thread.currentThread().getStackTrace().length > 2) {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        } else {
            return "undefined";
        }
    }

    public String imprimirLogsEntrada(OperacionMonedaExtranjeraTO operacion) {

        String jsonResponse = "";
        try {
            jsonResponse = objectMapper.writeValueAsString(operacion);
        } catch (JsonProcessingException e) {
            log.error("Ocurrio un error" + e);
        }

        return jsonResponse;
    }

    public String imprimirLogsSalida(OperacionMonedaExtranjeraModel operacion) {

        String jsonResponse = "";
        try {
            jsonResponse = objectMapper.writeValueAsString(operacion);
        } catch (JsonProcessingException e) {
            log.error("Ocurrio un error" + e);
        }

        return jsonResponse;
    }

    public XMLGregorianCalendar obtenerFechaXmlGregorian() {
        LocalDateTime localDate = LocalDateTime.now();
        GregorianCalendar calender = new GregorianCalendar();
        Date utilDate = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
        calender.setTime(utilDate);
        XMLGregorianCalendar xmlCal = null;
        try {
            xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
        } catch (DatatypeConfigurationException e) {
            log.error("error al obtener newXMLGregorianCalendar : {}",e);
        }
        return xmlCal;
    }

    public XMLGregorianCalendar obtenerFechaXmlGregorian(LocalDateTime local) {
        LocalDateTime localDate = local;
        GregorianCalendar calender = new GregorianCalendar();
        Date utilDate = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
        calender.setTime(utilDate);
        XMLGregorianCalendar xmlCal = null;
        try {
            xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
        } catch (DatatypeConfigurationException e) {
            log.error("error al obtener newXMLGregorianCalendar : {}",e);
        }
        return xmlCal;
    }

    public LocalDateTime obtenerLocalDatetimeFromXMLGregorian(XMLGregorianCalendar greg) {

        LocalDateTime localDateTime = LocalDateTime.of(greg.getYear(),
                greg.getMonth(), greg.getDay(), greg.getHour(), greg.getMinute(),greg.getSecond());
        return localDateTime;
    }
}