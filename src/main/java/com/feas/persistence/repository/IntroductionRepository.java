package com.feas.persistence.repository;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.Introduction;
import com.feas.domain.entity.dto.SummaryLabour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface IntroductionRepository extends JpaRepository<Introduction, Long> {


    @Query("from Introduction p where p.requestNumberIf=:requestNumberId and p.operation <> 'D' ")
    List<Introduction> getAllIntroductionByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);

    @Query("from Introduction p where p.requestNumberIf=:requestNumberId and p.operation <> 'D' ")
    Page<Introduction> getAllIntroductionByRequestNumberAsPage(@Param("requestNumberId") BigDecimal requestNumberId, Pageable page);
/*
    public Introduction save(Introduction economicalStudySummary){
        return introductionRepository.save(economicalStudySummary);
    }
    public Optional<Introduction> findById(Long id) {
        return  introductionRepository.findById(id);
    }*/


}
