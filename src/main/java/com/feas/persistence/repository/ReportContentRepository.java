package com.feas.persistence.repository;


import com.feas.domain.entity.Introduction;
import com.feas.domain.entity.ReportContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ReportContentRepository extends JpaRepository<ReportContent, Long> {
    @Query("from ReportContent p where p.requestNumberIf=:requestNumberId and (p.operation != 'D'or p.operation IS NULL )")
    List<ReportContent> getAllReportContentByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);


}
