package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.ManpowerType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
public interface ManpowerTypeRepository extends JpaRepository<ManpowerType,Long> {
}
