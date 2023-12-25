package com.feas.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.ProposedProjectEquipment;

@Repository
public interface ProposedProjectEquipmentRepository extends JpaRepository<ProposedProjectEquipment, Long> {

	@Query("select p from ProposedProjectEquipment p where p.operation != 'D' and "
			+ " p.licenseNumberIf=:licenseNumberIf and p.requestNumberIf=:requestNumberIf order by snoS asc")
	List<ProposedProjectEquipment> QueryAll(@Param("licenseNumberIf") Long licenseNumberIf,@Param("requestNumberIf") Long requestNumberIf);

@Query(value = "select nvl(loc_equip,0) loc_equip ,request_number_id REQUEST_NUMBER_IF   \n" +
		"from    \n" +
		"(select sum(round(nvl(PROPOSEDPROJECTEQUIPMENT.UNIT_PRICE_CY,0)*nvl(PROPOSEDPROJECTEQUIPMENT.EXCHANGE_RATE_CY,0)*nvl(PROPOSEDPROJECTEQUIPMENT.QUANTITY_NR,0)))             \n" +
		" as loc_equip ,PROPOSEDPROJECTEQUIPMENT.REQUEST_NUMBER_IF              \n" +
		"from proposed_project_equipment proposedprojectequipment               \n" +
		"where PROPOSEDPROJECTEQUIPMENT.REQUEST_NUMBER_IF=:requestNumberIf               \n" +
		"and (proposedprojectequipment.EQUIP_PERC_IF =4  or MANUF_CTRY_CODE_IF IN (1,115,225,10001)             \n" +
		") --AND nvl(proposedprojectequipment.exchange_rate_cy,1)=1           \n" +
		"AND PROPOSEDPROJECTEQUIPMENT.OPERATION<>'D'              \n" +
		"group by PROPOSEDPROJECTEQUIPMENT.REQUEST_NUMBER_IF), temp_request   \n" +
		"where request_number_id=request_number_if(+)   \n" +
		"and request_number_id=:requestNumberIf",nativeQuery = true)
          BigDecimal getLocalEquip(@Param("requestNumberIf") Long requestNumberIf);
	
}
