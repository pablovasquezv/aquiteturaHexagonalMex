package cl.banchile.bchrest.administra.moneda.extranjera.common.exception;

/**
 * @author Pablo
 *
 */

/**
 * Excepción a ser lanzada cuando existe una operación que no es soportada
 * por Adaptadores o servicio de dominio y de aplicación
 */
public class OperationNotSupportedException extends RuntimeException {
    public OperationNotSupportedException(String message){
        super(message);
    }
    public OperationNotSupportedException(String message, Throwable err){
        super(message, err);
    }
}