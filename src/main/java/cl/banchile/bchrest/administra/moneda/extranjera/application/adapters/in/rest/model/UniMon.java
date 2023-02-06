package cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * @author Pablo
 *
 */

@Entity(name = "uniMon")
@Data
@Table(name= "tg_uni_mon")
public class UniMon {
    @Id
    @Column (name="COD_MON")
    private String codigo;
    @Column (name="DES_MON")
    private String descripcion;
}
