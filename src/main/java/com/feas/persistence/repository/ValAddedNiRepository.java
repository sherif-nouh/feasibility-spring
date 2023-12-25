package com.feas.persistence.repository;

import com.feas.domain.entity.ValAddedNi;
import com.feas.domain.entity.dto.ValAddedNiReadOnlyFields;
import com.feas.domain.entity.dto.ValAddedNiReadOnlyFieldsDTO;
import com.feas.domain.entity.dto.ValAddedNiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
public interface ValAddedNiRepository extends JpaRepository<ValAddedNi,Long> {

    @Query(value = "SELECT                \n " +
            "  (SELECT (sum(((nvl(no_of_male,0)+nvl( no_of_f_male,0)) * (monthly_sal_cy))*12))* (1.1)                \n" +
            "  FROM proposed_manpower                \n" +
            "  WHERE request_number_if= :requestNumber                \n" +
            "  AND operation         <>'D'                \n" +
            "  ) workerRemuneration --اجور العاملين و تامنهم                \n" +
            "  ,                \n" +
            "  (SELECT audit_exp_cy                \n" +
            "  FROM yearly_fixed_expenses                \n" +
            "  WHERE request_number_if = :requestNumber  AND operation<>'D'              \n" +
            "  ) yearlyFixedExpenses --تدقيق الحسابات                \n" +
            "  ,                \n" +
            "  (SELECT advert_exp_cy                \n" +
            "  FROM yearly_fixed_expenses                \n" +
            "  WHERE request_number_if = :requestNumber  AND operation<>'D'              \n" +
            "  ) advertExpCy --مصاريف دعايه واعلان                 \n" +
            "  ,                \n" +
            "  (SELECT (nvl(cost_of_build_const_cy,0)+nvl(cost_of_equip_cy,0))*0.005                \n" +
            "  FROM fixed_assets_cost                \n" +
            "  WHERE request_number_if = :requestNumber    AND operation<>'D'            \n" +
            "  ) buildingTools --تأمين المباني والمعدات                \n" +
            "  ,(SELECT veh_insur_cy                \n" +
            "FROM   yearly_fixed_expenses                \n" +
            "WHERE  operation<>'D'          \n" +
            "AND request_number_if = :requestNumber                \n" +
            "  ) vehInsurcy --تأمين السيارات                \n" +
            "  ,(                \n" +
            "  SELECT  val.PROJECT_CHARGES              \n" +
            "FROM VAL_ADDED_NI val                \n" +
            "WHERE val.REQUEST_NUMBER_IF = :requestNumber AND val.LICENSE_NUMBER_IF=:licenseNumber AND operation<>'D'               \n" +
            "  ) projectCharge --عائدات المشروع                 \n" +
            "  ,                \n" +
            "  (                \n" +
            "  SELECT distinct nvl ((nvl(loan_from_indbank_cy,0)*nvl(perc_interest_loan_comb_nr,0)/100)+                \n" +
            "  (nvl(loan_from_commbank_cy,0)*nvl(perc_interest_loan_indb_nr,0)/100) ,0 )              \n" +
            "  FROM project_financing WHERE  license_number_if = :licenseNumber                \n" +
            "  AND request_number_if = :requestNumber   AND operation <>'D'              \n" +
            "  ) interestOnloan  -- فوائد القروض                \n" +
            "  ,                \n" +
            "  (                \n" +
            "  SELECT  DISTINCT nvl(royalties,0)                  \n" +
            "        FROM    project_profit                \n" +
            "        WHERE   request_number_if = :requestNumber AND operation <>'D'                 \n" +
            "  ) royalties  --حقوق التصنيع :                \n" +
            "  ,(               \n" +
            "   SELECT DISTINCT nvl(remigrations,0)                 \n" +
            "        FROM    val_added_ni               \n" +
            "        WHERE   request_number_if = :requestNumber AND operation <>'D'              \n" +
            "  ) remigrations  --أجور مدفوعة للعاملين مقابل خدمة :               \n" +
            "  ,               \n" +
            "  (               \n" +
            "   SELECT audit_exp_cy                \n" +
            "  FROM yearly_fixed_expenses                \n" +
            "  WHERE request_number_if = :requestNumber  AND operation<>'D'             \n" +
            "  ) auditingAccounts  --تدقيق الحسابات :               \n" +
            ",              \n " +
            "  (              \n " +
            "  SELECT DISTINCT  nvl(project_revenue,0)                \n" +
            "        FROM    project_profit              \n" +
            "        WHERE   request_number_if = :requestNumber  AND operation <>'D'          \n" +
            "  ) projectRevenue                \n" +
            "FROM dual ",nativeQuery = true)
    ValAddedNiReadOnlyFields getAllValAddedNiReadOnlyFields(@Param("requestNumber") BigDecimal requestNumber, @Param("licenseNumber") BigDecimal licenseNumber);


    Optional<ValAddedNi> findValAddedNiByRequestNumberIfAndLicenseNumberIf(BigDecimal requestNumber, BigDecimal licenseNumber);

    @Query(value = """
            SELECT
                valaddedni.econ_study_number_if ,
                valaddedni.project_charges,
                valaddedni.worker_remuneration,
                valaddedni.auditing_accounts,
                valaddedni.building_tools,
                valaddedni.publicity_adv,
                valaddedni.veh_insur_cy,
                valaddedni.remigrations,
                valaddedni.license_number_if,
                valaddedni.request_number_if,
                valaddedni.operation,
                valaddedni.insert_by,
                valaddedni.modify_by,
                ( nvl(valaddedni.project_charges, 0)
                + nvl(valaddedni.worker_remuneration, 0)
                + nvl(valaddedni.auditing_accounts, 0)
                + nvl(valaddedni.building_tools, 0)
                + nvl(valaddedni.publicity_adv, 0)
                + nvl(valaddedni.veh_insur_cy, 0)
                + nvl(valaddedni.remigrations, 0) ) totalvalueadded,
                projectprofit.project_revenue,
                nvl(projectprofit.interest_on_loan, 0)    interestonloan,
                projectprofit.royalties royalties,
                ( nvl(projectprofit.project_revenue, 0)
                - nvl(projectprofit.interest_on_loan, 0)
                - nvl(projectprofit.royalties, 0) )  sumprojectprofit
            FROM
                     val_added_ni valaddedni
                JOIN project_profit projectprofit ON valaddedni.request_number_if = projectprofit.request_number_if
            WHERE
                ( valaddedni.license_number_if = :licenseNumber )
                AND ( valaddedni.request_number_if = :requestNumber )
            
            """ ,nativeQuery = true)
    ValAddedNiResponse getValAddedNiByRequestAndLicence(@Param("requestNumber") BigDecimal requestNumber, @Param("licenseNumber") BigDecimal licenseNumber);
    @Query(value = """
        SELECT ADVERT_EXP_CY FROM YEARLY_FIXED_EXPENSES WHERE REQUEST_NUMBER_IF=:requestNumberId
        """,nativeQuery = true)
     BigDecimal calAdvertExpCytQuery(@Param("requestNumberId") BigDecimal requestNumberId) ;

    @Query(value = """
        SELECT  AUDIT_EXP_CY FROM YEARLY_FIXED_EXPENSES WHERE REQUEST_NUMBER_IF=:requestNumberId
        """,nativeQuery = true)
    BigDecimal calAuditExpCy (@Param("requestNumberId") BigDecimal requestNumberId) ;
}
