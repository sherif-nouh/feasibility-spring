package com.feas.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.GeneralInformation;

@Repository
public interface GeneralInformationRepository extends JpaRepository<GeneralInformation, Long> {



}
