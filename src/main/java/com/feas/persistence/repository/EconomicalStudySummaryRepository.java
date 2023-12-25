package com.feas.persistence.repository;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.EconomicalStudySummaryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomicalStudySummaryRepository extends JpaRepository<EconomicalStudySummary, EconomicalStudySummaryPK> {
}
