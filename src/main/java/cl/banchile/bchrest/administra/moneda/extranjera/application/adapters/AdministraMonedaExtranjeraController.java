package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters;

import javax.validation.Valid;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.EstadoOperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.MonedaResponse;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionMonedaExtranjeraModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.out.externalservice.IProcesoTEO;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.out.externalservice.OperacionBancoEJBAdapter;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.out.externalservice.OperacionInstruccionPagoEJBAdapter;
import cl.banchile.go.ejb.OperacionMonedaExtranjeraTO;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pablo
 *
 */

/**
 * Clase de implementación de Adaptador Rest
 * Rest Controller
 */
@Slf4j
@RestController
@RequestMapping(path = "/moneda-extranjera/v1")
public class AdministraMonedaExtranjeraController {

    @Autowired
    private OperacionBancoEJBAdapter operacionBancoEJBAdapter;

    @Autowired
    private OperacionInstruccionPagoEJBAdapter instruccionAdapter;

    @Autowired
    private IProcesoTEO iProcesoTEO;

    @PostMapping("/operaciones")
    @ApiOperation(value = "Método para realizar un ingreso de operación de Moneda Extranjera")
    public ResponseEntity<OperacionMonedaExtranjeraModel> crearOperacionMonedaExtranjera(@Valid @RequestBody OperacionMonedaExtranjeraTO operacion) {
        OperacionMonedaExtranjeraModel resp = operacionBancoEJBAdapter.agregarOperacionMonedaExtranjera(operacion);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    @GetMapping("/monedas")
    @ApiOperation(value = "Método para listar monedas")
    public ResponseEntity<?>getMonedas(){
        MonedaResponse response = iProcesoTEO.listadoMonedas();
        return new ResponseEntity<>(response.getResponse(), response.getStatus());
    }

    @GetMapping("/tipo-cambio/{moneda}")
    @ApiOperation(value = "Método para obtener cálculos para precio y venta respecto a la paridad con filtrado por moneda ingresada")
    public ResponseEntity<?>getPrecioByMoneda(@Valid @PathVariable(value = "moneda")String moneda){
        MonedaResponse response = iProcesoTEO.getPrecioByMoneda(moneda);
        return new ResponseEntity<>(response.getResponse(),response.getStatus());
    }

    @PostMapping("/operaciones/instruicciones")
    @Operation(summary = "Operación instruccion de Monedas Extranjeras")
    public ResponseEntity<EstadoOperacionInstruccionModel> crearOperacionInstruccion(@Valid @RequestBody OperacionInstruccionModel operacion) {
        EstadoOperacionInstruccionModel resp = instruccionAdapter.agregarIsntruiccionPago(operacion);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}