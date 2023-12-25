package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.Material;
import com.feas.domain.entity.lookups.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sherif Nouh
 * @Date ١٧/٠٥/٢٠٢٣
 */
public interface UnitRepository extends JpaRepository<Unit,Long> {
}
