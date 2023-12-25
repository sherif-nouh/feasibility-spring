package com.feas.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.WfInboxNew;

@Repository
public interface WfInboxNewRepository extends JpaRepository<WfInboxNew, Long> {

}
