package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.RemarksTech;
import com.feas.domain.entity.lookups.StockType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sherif Nouh
 * @Date ٠٦/٠٧/٢٠٢٣
 */
public interface StockTypeRepository extends JpaRepository<StockType, Long> {
}
