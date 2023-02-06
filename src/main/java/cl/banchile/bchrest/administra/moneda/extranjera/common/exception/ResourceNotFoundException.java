package cl.banchile.bchrest.administra.moneda.extranjera.common.exception;

/**
 * @author Pablo
 *
 */

/**
 * Excepción a ser lanzada cuando se el recurso solicitado
 * no existe en el dominio
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable err){
        super(message, err);
    }
}
