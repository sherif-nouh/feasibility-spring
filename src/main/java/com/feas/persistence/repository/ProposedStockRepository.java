package com.feas.persistence.repository;

import com.feas.domain.entity.ProposedStock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠١/٠٢/٢٠٢٣
 */
public interface ProposedStockRepository extends JpaRepository<ProposedStock,Long> {
    @Query("from ProposedStock ps where ps.requestNumberIf=:requestNumberId and ps.operation != 'D' order by ps.sno")
    List<ProposedStock> getAllProposedStockByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);
    @Query("from ProposedStock ps where ps.requestNumberIf=:requestNumberId and ps.operation != 'D' order by ps.sno")
    Page<ProposedStock> getAllProposedStockByRequestNumberAsPage(@Param("requestNumberId") BigDecimal requestNumberId, Pageable page);


    @Query("select t.remarksBydept from TempRequest t where t.requestNumberId=:requestNumberId")
    String getRemarksBydept(@Param("requestNumberId") BigDecimal requestNumberId);

}
