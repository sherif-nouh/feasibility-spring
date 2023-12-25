package com.feas.persistence.repository;

import com.feas.domain.entity.TechnicalStudySummary;
import com.feas.domain.entity.TechnicalStudySummaryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalStudySummaryRepository extends JpaRepository<TechnicalStudySummary, TechnicalStudySummaryPK> {



}
