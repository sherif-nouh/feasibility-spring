package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.lookups.Material;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sherif Nouh
 * @Date ١٧/٠٥/٢٠٢٣
 */
public interface MaterialRepository extends JpaRepository<Material,Long> {
}
