package com.feas.persistence.repository;

import com.feas.domain.entity.EstimatedYearlySales;
import com.feas.domain.entity.FinishedGoodsStorage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EstimatedYearlySaleRepository extends JpaRepository<EstimatedYearlySales, Long> {


    @Query("from EstimatedYearlySales p where p.requestNumberIf=:requestNumberId and p.operation <> 'D' order by p.sno")
    List<EstimatedYearlySales> getAllEstimatedYearlySaleByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);

    @Query("from EstimatedYearlySales p where p.requestNumberIf=:requestNumberId and p.operation <> 'D' order by p.sno")
    Page<EstimatedYearlySales> getAllEstimatedYearlySaleByRequestNumberPage(@Param("requestNumberId") BigDecimal requestNumberId, Pageable page);

}
