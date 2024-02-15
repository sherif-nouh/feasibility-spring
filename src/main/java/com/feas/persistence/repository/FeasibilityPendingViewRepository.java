package com.feas.persistence.repository;

import com.feas.domain.entity.FeasibilityPendingVw;
import com.feas.domain.entity.FeasibilityPendingVwKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface FeasibilityPendingViewRepository extends JpaRepository<FeasibilityPendingVw, FeasibilityPendingVwKey> {
   public List<FeasibilityPendingVw> findByRequestNumberIdAndLicenseNo(long requestNumberId, String licenseNo);
  }
