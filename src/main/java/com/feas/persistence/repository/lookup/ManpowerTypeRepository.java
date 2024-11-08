package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.Manpower;
import com.feas.domain.entity.lookups.ManpowerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
public interface ManpowerTypeRepository extends JpaRepository<ManpowerType,Long> {
    List<ManpowerType> findByOperationNot(String d);
}
