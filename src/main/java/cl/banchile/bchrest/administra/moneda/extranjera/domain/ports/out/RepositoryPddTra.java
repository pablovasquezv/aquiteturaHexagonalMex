package cl.banchile.bchrest.administra.moneda.extranjera.domain.ports.out;

import cl.banchile.bchrest.administra.moneda.extranjera.application.adapters.in.rest.model.PddTra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Pablo
 *
 */

@Repository
public interface RepositoryPddTra extends CrudRepository<PddTra, Long> {
    @Query(value =
            "select tra.TG_PDD_MON_TG_UNI_MON_COD_MON_ as codigomoneda, \n" +
                    "       uni.SBL_MON as simbolomoneda, \n" +
                    "       ROUND(VAL_PDD_CLI_CPA ,4)  as paridadcompra, \n" +
                    "       ROUND(VAL_PDD_CLI_VTA ,4) as paridadventa, \n" +
                    "       ROUND((pre.PRE_PST_CLI_CPA/VAL_PDD_CLI_CPA),2) as tipodecambiocompra, \n" +
                    "       TRUNC((pre.PRE_PST_CLI_VTA/VAL_PDD_CLI_VTA),2) as tipodecambioventa \n" +
                    "from   td_pdd_tra tra \n" +
                    ",      td_par_gen par \n" +
                    ",      tg_uni_mon uni \n" +
                    ",      td_pre_tra pre \n" +
                    ",      (select min(tra.mnt_min) mnt_min, TG_PDD_MON_TG_UNI_MON_COD_MON_ mon \n" +
                    "        from   td_pdd_tra tra \n" +
                    "        ,      td_par_gen par \n" +
                    "        where  tra.TG_PDD_MON_TG_UNI_MON_COD_MON_ = :moneda \n" +
                    "        and    tra.tg_pdd_mon_fec_pdd = par.fec_pro group by TG_PDD_MON_TG_UNI_MON_COD_MON_) min \n" +
                    ",      (select min(mnt_min) mnt_min  from td_pre_tra \n" +
                    "        where  ta_grp_aut_cod_grp = 'BAN-CHI') pre_min \n" +
                    "where  tra.tg_pdd_mon_fec_pdd = par.fec_pro \n" +
                    "and    tra.mnt_min = min.mnt_min \n" +
                    "and    pre.mnt_min = pre_min.mnt_min \n" +
                    "and    pre.ta_grp_aut_cod_grp = 'BAN-CHI' \n" +
                    "and    tra.TG_PDD_MON_TG_UNI_MON_COD_MON_ = uni.cod_mon \n" +
                    "and    tra.TG_PDD_MON_TG_UNI_MON_COD_MON_ = min.mon", nativeQuery = true)
    PddTra getPrecioByMoneda(@Param(value = "moneda") String moneda);
}