package com.feas.persistence.repository;

import com.feas.domain.entity.ProjectRevenue;
import com.feas.domain.entity.ProjectRevenuePK;
import com.feas.domain.entity.dto.ProjectRevenueCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Transactional
public interface ProjectRevenueRepository extends JpaRepository<ProjectRevenue, ProjectRevenuePK> {

    @Modifying
    @Query(value = " update project_revenue pr set pr.yrly_sales_val_cy=:yrlySalesValCy where pr.request_number_if=:requestNumberIf ",nativeQuery = true)
    int updateYrlySalesValCyFromEstimatedYearlySales(long requestNumberIf,BigDecimal yrlySalesValCy);


    @Query(value = " SELECT \n" +
            "    projectrevenue.project_number_if projectnumberif,\n" +
            "    projectrevenue.request_number_if requestnumberif,\n" +
            "    nvl(projectrevenue.yrly_sales_val_cy, 0) yrlysalesvalcy,\n" +
            "    nvl(projectrevenue.yrly_prod_exp_cy, 0) yrlyprodexpcy,\n" +
            "    nvl(projectrevenue.perc_prod_loss_cy, 0) percprodlosscy,\n" +
            "    nvl(projectrevenue.production_loss_nr, 0) production_loss_nr,\n" +
            "    nvl(projectrevenue.project_revenue, 0) projectrevenue,\n" +
            "    projectrevenue.user_name username,\n" +
            "    projectrevenue.operation operation,\n" +
            "    projectrevenue.date_stamp datestamp,\n" +
            "    projectrevenue.license_number_if licensenumberif,\n" +
            "    projectrevenue.sum_yrly_prod_exp_cy sumyrlyprodexpcy,\n" +
            "    ( nvl(estimateyearlysales.quantity_nr, 0) * nvl(estimateyearlysales.unit_price_cy, 0) ) sumyearlysalesvaluecy,\n" +
            "    nvl(fixedassetscost.cost_of_build_const_cy, 0) fixedassetcostbuildcons,\n" +
            "    nvl(fixedassetscost.cost_of_equip_cy, 0) fixedassetcostequipment,\n" +
            "    ( nvl(yearlyfixedexpenses.ind_space_rent_cy, 0) + nvl(yearlyfixedexpenses.salaries_cy, 0) + nvl(yearlyfixedexpenses.allowances_cy,\n" +
            "    0) + nvl(yearlyfixedexpenses.audit_exp_cy, 0) + nvl(yearlyfixedexpenses.advert_exp_cy, 0) + nvl(yearlyfixedexpenses.trvl_allw_consult_exp_cy,\n" +
            "    0) + nvl(yearlyfixedexpenses.gen_exp_cy, 0) + nvl(yearlyfixedexpenses.profits_notincl_prod_cy, 0) + nvl(yearlyfixedexpenses.veh_insur_cy,\n" +
            "    0) + nvl(yearlyfixedexpenses.nonroutine_maint_exp_cy, 0) + ( ( nvl(fixedassetscost.cost_of_build_const_cy, 0) + nvl(fixedassetscost.\n" +
            "    cost_of_equip_cy, 0) ) * ( nvl(yearlyfixedexpenses.insu_percexp_buildtools_cy, 0) / 100 ) ) ) yearlyfixedexpense,\n" +
            "    ( nvl(yearlydepreciation.dep_build_const_cy, 0) + nvl(yearlydepreciation.dep_equip_after_instal_cy, 0) + nvl(yearlydepreciation.dep_air_cond_cy,\n" +
            "    0) + nvl(yearlydepreciation.dep_of_off_fur_cy, 0) + nvl(yearlydepreciation.dep_of_fur_for_wahouse_cy, 0) + nvl(yearlydepreciation.\n" +
            "    dep_of_ext_transp_cy, 0) + nvl(yearlydepreciation.dep_int_transp_cy, 0) ) yearlydepreciation,\n" +
            "    ( nvl(yearlyvariableexpenses.raw_mat_cov_pack_cy, 0) + nvl(yearlyvariableexpenses.direct_labor_salar_cy, 0) + ( nvl(yearlyvariableexpenses.\n" +
            "    direct_labor_salar_cy, 0) ) * ( nvl(yearlyvariableexpenses.aliw_direct_labor_cy, 0) / 100 ) + nvl(yearlyvariableexpenses.emp_insu_cy,\n" +
            "    0) + nvl(yearlyvariableexpenses.gen_prod_fac_uti_cy, 0) + nvl(yearlyvariableexpenses.print_stat_cy, 0) ) yearlyvariableexpense1,\n" +
            "    ( nvl(fixedassetscost.cost_of_build_const_cy, 0) ) yearlyvariableexpense2,\n" +
            "    ( nvl(yearlyvariableexpenses.perc_maint_build_proj_cy, 0) ) yearlyvariableexpense3,\n" +
            "    ( nvl(fixedassetscost.cost_of_equip_cy, 0) + nvl(fixedassetscost.cost_of_sparts_cy, 0) ) yearlyvariableexpense4,\n" +
            "    ( nvl(yearlyvariableexpenses.maint_spares_equip_cy, 0) ) yearlyvariableexpense5\n" +
            " FROM\n" +
            "    project_revenue          projectrevenue,\n" +
            "    estimated_yearly_sales   estimateyearlysales,\n" +
            "    yearly_fixed_expenses    yearlyfixedexpenses,\n" +
            "    fixed_assets_cost        fixedassetscost,\n" +
            "    yearly_depreciation      yearlydepreciation,\n" +
            "    yearly_variable_expenses yearlyvariableexpenses\n" +
            " WHERE\n" +
            "    ( projectrevenue.request_number_if = :requestnumber )\n" +
            "    AND ( projectrevenue.license_number_if = :licensenumber )\n" +
            "    AND projectrevenue.request_number_if = estimateyearlysales.request_number_if (+)\n" +
            "    AND projectrevenue.request_number_if = yearlyfixedexpenses.request_number_if (+)\n" +
            "    AND projectrevenue.request_number_if = fixedassetscost.request_number_if (+)\n" +
            "    AND projectrevenue.request_number_if = yearlydepreciation.request_number_if (+)\n" +
            "    AND projectrevenue.request_number_if = yearlyvariableexpenses.request_number_if (+)",nativeQuery = true)
          List<ProjectRevenueCustom> getProjectRevenueCustom(long requestnumber, long licensenumber);
}
