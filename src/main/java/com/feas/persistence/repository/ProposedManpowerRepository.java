package com.feas.persistence.repository;

import com.feas.domain.entity.dto.SummaryLabour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.ProposedManpower;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProposedManpowerRepository extends JpaRepository<ProposedManpower, Long> {


    @Query("from ProposedManpower p where p.requestNumberIf=:requestNumberId and p.operation <> 'D' order by p.sno")
    List<ProposedManpower> getAllManPowerByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);

    @Query("from ProposedManpower p where p.requestNumberIf=:requestNumberId and p.operation <> 'D' order by p.sno")
    Page<ProposedManpower> getAllManPowerByRequestNumberAsPage(@Param("requestNumberId") BigDecimal requestNumberId, Pageable page);


    @Query(value = "SELECT  sum(nvl(ProposedManpower.NO_OF_MALE,0)+    \n" +
            "nvl(ProposedManpower.NO_OF_F_MALE,0)) summaryEmployee,sum((nvl(ProposedManpower.NO_OF_MALE,0)+    \n" +
            "nvl(ProposedManpower.NO_OF_F_MALE,0))*    \n" +
            "nvl(ProposedManpower.MONTHLY_SAL_CY,0)*12)*1.1 summaryLabour, sum((nvl(ProposedManpower.NO_OF_MALE,0)+   \n" +
            "nvl(ProposedManpower.NO_OF_F_MALE,0))*   \n" +
            "nvl(ProposedManpower.MONTHLY_SAL_CY,0)*12) summaryYearly,PROPOSEDMANPOWER.REQUEST_NUMBER_IF, \n" +
            "(select  sum((nvl(ProposedManpower.NO_OF_MALE,0)+       \n" +
            "nvl(ProposedManpower.NO_OF_F_MALE,0))*       \n" +
            "nvl(ProposedManpower.MONTHLY_SAL_CY,0)*12)        \n" +
            "from PROPOSED_MANPOWER ProposedManpower,MANPOWER_type t       \n" +
            "where  PROPOSEDMANPOWER.MANP_TYPE=T.MANPOWER_CODE_ID     \n" +
            "and PROPOSEDMANPOWER.REQUEST_NUMBER_IF=:requestNumberId     \n" +
            "and T.MANPOWER_CODE_ID <>1 \n" +
            "and PROPOSEDMANPOWER.OPERATION<>'D')  tinDirect , \n" +
            "(select  sum((nvl(ProposedManpower.NO_OF_MALE,0)+     \n" +
            "nvl(ProposedManpower.NO_OF_F_MALE,0))*     \n" +
            "nvl(ProposedManpower.MONTHLY_SAL_CY,0)*12)     \n" +
            "from PROPOSED_MANPOWER ProposedManpower,MANPOWER_type t     \n" +
            "where  PROPOSEDMANPOWER.MANP_TYPE=T.MANPOWER_CODE_ID   \n" +
            "and PROPOSEDMANPOWER.REQUEST_NUMBER_IF=:requestNumberId   \n" +
            "and T.MANPOWER_CODE_ID <>2     \n" +
            "AND PROPOSEDMANPOWER.OPERATION<>'D') tDirect \n" +
            "FROM PROPOSED_MANPOWER ProposedManpower    \n" +
            "where PROPOSEDMANPOWER.REQUEST_NUMBER_IF=:requestNumberId   \n" +
            "and PROPOSEDMANPOWER.OPERATION <>'D'  \n" +
            "group by PROPOSEDMANPOWER.REQUEST_NUMBER_IF" ,nativeQuery = true)
    SummaryLabour getSummaryLabour(@Param("requestNumberId") BigDecimal requestNumberId);


    @Query("select t.deptRemarks from TempRequest t where t.requestNumberId=:requestNumberId")
    String getDeptRemarks(@Param("requestNumberId") BigDecimal requestNumberId);



}
