package com.feas.persistence.repository;

import com.feas.domain.entity.ProductionLineArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
public interface ProductionLineAreaRepository extends JpaRepository<ProductionLineArea,Long> {

    @Query("from ProductionLineArea p where p.requestNumberIf=:requestNumberId and p.licenseNumberIf=:licenseNumberIf and p.operation <> 'D' order by p.sno")
    List<ProductionLineArea> getAllProductionLineAreaByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId,@Param("licenseNumberIf") BigDecimal licenseNumberIf);

}
