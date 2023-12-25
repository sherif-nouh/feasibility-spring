package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.Building;
import com.feas.domain.entity.lookups.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sherif Nouh
 * @Date ١٤/٠٦/٢٠٢٣
 */
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
