package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.ReportContentDefault;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReportContentRepository extends JpaRepository<ReportContentDefault, Long> {

}