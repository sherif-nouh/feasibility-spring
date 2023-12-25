package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.ProdOrigin;
import com.feas.domain.entity.lookups.StockType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sherif Nouh
 * @Date ٠٦/٠٧/٢٠٢٣
 */
public interface ProdOriginRepository extends JpaRepository<ProdOrigin, Long> {
}
