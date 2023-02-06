package cl.banchile.bchrest.administra.moneda.extranjera.aplication.adapters.in.rest.externalservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.EstadoOperacionEjbModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.EstadoOperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.OperacionInstruccionModel;
import cl.banchile.bchrest.administra.moneda.extranjera.common.utils.Utils;
import cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out.OperacionInstruccionPagoEJBPort;
import cl.banchile.esb.schema.canales.ingreso.transferencia.req.v2020.CanalesIngresoTransferenciaExpReqType;
import cl.banchile.esb.schema.canales.ingreso.transferencia.req.v2020.RequestEntry;
import cl.banchile.esb.schema.canales.ingreso.transferencia.resp.v2020.CanalesIngresoTransferenciaExpRespType;
import cl.banchile.esb.wsdl.canales.ingreso.transferencia.v1.CanalesIngresoTransferencia;
import cl.banchile.esb.wsdl.canales.ingreso.transferencia.v1.CanalesIngresoTransferenciaPt;
import cl.banchile.esb.wsdl.canales.ingreso.transferencia.v1.FaultMsg;
import cl.banchile.framework.lib.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperacionInstruccionPagoEJBAdapter implements OperacionInstruccionPagoEJBPort {

    private CanalesIngresoTransferencia service;

    @Autowired
    private Utils util;

    public OperacionInstruccionPagoEJBAdapter(@Value("${service.operacion-instruccion.url}") String url) {
        try {
            this.service = new CanalesIngresoTransferencia(new URL(url));
        } catch (MalformedURLException e) {
            log.error("Error: " + e);
        }
    }

    @Override
    public EstadoOperacionInstruccionModel agregarIsntruiccionPago(OperacionInstruccionModel op) {

        log.info("req: {} ", op);
        EstadoOperacionInstruccionModel resp = EstadoOperacionInstruccionModel.builder().build();
        CanalesIngresoTransferenciaPt port = service.getCanalesIngresoTransferenciaPort();

        CanalesIngresoTransferenciaExpReqType typeReq = new CanalesIngresoTransferenciaExpReqType();
        CanalesIngresoTransferenciaExpRespType respEJB = new CanalesIngresoTransferenciaExpRespType();
        List<RequestEntry> listaParam = new ArrayList();

        typeReq.setCanalOperacion(op.getCanalOperacion());
        typeReq.setRutCliente(op.getRutCliente().longValue());
        typeReq.setIdentificadorBeneficiario(op.getIdentificadorBeneficiario().toString());
        typeReq.setNumeroOrden(op.getNumeroOrden().longValue());
        typeReq.setNumeroInstruccionPago(op.getNumeroInstruccionPago().longValue());
        typeReq.setNumeroOperacion(op.getNumeroOperacion().longValue());
        typeReq.setProducto(op.getProducto());
        typeReq.setIdTransaccion(op.getIdTransaccion().toString());
        typeReq.setObservacion(op.getObservacion());

        listaParam = typeReq.getParametro();
        listaParam = agregarListaParam(op);
        if (!listaParam.isEmpty() && (listaParam.get(0)!=null)){
            typeReq.getParametro().addAll(listaParam);
        }


        try {
            respEJB = port.canalesIngresoTransferenciaOp(typeReq);
            resp = convertirResponse(respEJB);
            log.info("resp: {} ", resp);
        } catch (FaultMsg e) {
            log.error("Error al consultar fuse de insgreso de instruccion: {} ", e);
        }

        return resp;
    }

    private EstadoOperacionInstruccionModel convertirResponse(CanalesIngresoTransferenciaExpRespType respEJB) {

        String code =  respEJB.getEstadoOperacion().getCodigoOperacion();
        String glosa = respEJB.getEstadoOperacion().getGlosaOperacion();

        if ((code!=null) && (code!="000")){
            return EstadoOperacionInstruccionModel.builder()
                    .estadoOperacion(EstadoOperacionEjbModel.builder().codigoOperacion("001").glosaOperacion(glosa).build()).build();
        }

        return EstadoOperacionInstruccionModel.builder()
                .estadoOperacion(EstadoOperacionEjbModel.builder().codigoOperacion("000").glosaOperacion("Operacion realizada con éxito").build()).build();

    }

    private List<RequestEntry> agregarListaParam(OperacionInstruccionModel op) {


        if (StringUtils.isEmpty(op.getParametros().get(0).getName()) ) {
            return  new ArrayList();
        }

        List<RequestEntry> listaReturn = new ArrayList();
        op.getParametros().stream().forEach((p) -> {
            RequestEntry req = new RequestEntry();
            req.setName(p.getName());
            req.setStringData(p.getStringData());

            req.setDateData(util.obtenerFechaXmlGregorian(p.getDateData()));
            req.setNumberData(p.getNumberData());
            listaReturn.add(req);
        });

        return listaReturn;
    }

}
