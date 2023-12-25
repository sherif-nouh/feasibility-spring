package com.feas.persistence.repository;

import com.feas.domain.entity.ProjectSetupCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */

@Repository
public interface ProjectSetupCostRepository extends JpaRepository<ProjectSetupCost,Long> {


     Optional<ProjectSetupCost> findFirstByRequestNumberIf(BigDecimal requestNumberIf);

}
