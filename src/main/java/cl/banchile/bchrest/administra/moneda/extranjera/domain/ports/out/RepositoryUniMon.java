package cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.UniMon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Pablo
 *
 */

@Repository
public interface RepositoryUniMon extends CrudRepository<UniMon, String> {
    @Query(value = "SELECT mon.cod_mon cod_mon, mon.des_mon des_mon \n" +
            "FROM td_par_gen par, tg_uni_mon mon, tg_pdd_mon pdd \n" +
            "WHERE pdd.tg_tip_pdd_cod_tip_pdd = par.tip_pdd AND \n" +
            "pdd.tg_uni_mon_cod_mon = par.cod_mon_dol AND \n" +
            "pdd.fec_pdd = par.fec_pro AND \n" +
            "pdd.tg_uni_mon_cod_mon_pdd = mon.cod_mon AND \n" +
            "NVL(mon.ind_dis_vnt, 'SI') <> 'AN' \n" +
            "ORDER BY des_mon", nativeQuery = true)
    List<UniMon> listadoMonedas();
}
