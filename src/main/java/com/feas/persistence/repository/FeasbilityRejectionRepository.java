package com.feas.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.FeasbilityRejection;

@Repository
public interface FeasbilityRejectionRepository extends JpaRepository<FeasbilityRejection, Long> {


}
