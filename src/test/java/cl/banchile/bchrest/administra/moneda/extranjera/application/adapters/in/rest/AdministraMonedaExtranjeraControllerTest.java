package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest;

import cl.banchile.bchrest.administra.moneda.extranjera.Util;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionMonedaExtranjeraModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.out.externalservice.OperacionBancoEJBAdapter;
import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.in.OperacionesBancoPort;
import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;

import javax.xml.datatype.DatatypeConfigurationException;
import java.text.ParseException;
/**
 * @author Pablo
 *
 *
@Slf4j
@WebMvcTest(AdministraMonedaExtranjeraController.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
public class AdministraMonedaExtranjeraControllerTest {
    // Constantes para evitar repetición de cadenas de caracteres
    /*private static final String BASE_PATH = "/moneda-entranjera/v1";
    private static final String ENDPOINT_OPERACION_MONEDA_EXTRANJERA = BASE_PATH + "/operaciones";
    private OperacionMonedaExtranjeraModel responseObj;
    private OperacionMonedaExtranjeraTO requestObj;

    @MockBean
    private OperacionBancoEJBAdapter operacionBancoEJBAdapter;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws DatatypeConfigurationException, ParseException {
        log.info("RUNNIG setUp");
    }


    @Test
    void crearOperacionMonedaExtranjera() {
        log.info("TEST OpercionMonedaExtranjera");
       try {
            requestObj = Util.jsonRequest();
            responseObj = Util.jsonResponseModel();

            String jsonRequest = objectMapper.writeValueAsString(requestObj);
            String jsonResponse = objectMapper.writeValueAsString(responseObj);

            /*Mockito.when(operacionBancoEJBAdapter.agregarOperacionMonedaExtranjera(requestObj))
                    .thenReturn(responseObj);*/
           /*Mockito.doReturn(responseObj).when(operacionBancoEJBAdapter).agregarOperacionMonedaExtranjera(requestObj);

            MvcResult result = mvc.perform(MockMvcRequestBuilders.post(ENDPOINT_OPERACION_MONEDA_EXTRANJERA)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonRequest)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn();

            String jsonResult = result.getResponse().getContentAsString();
            ///assertEquals(jsonResponse, jsonResult);
        } catch (Exception e) {
            log.error("Ha ocurrido un error en => " + getClass().getName() + "=> " + e.getMessage());
        }

    }
}*/