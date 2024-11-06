package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.Product;
import com.feas.domain.entity.lookups.VehicalCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٣١/٠٥/٢٠٢٣
 */
public interface VehicalCodeRepository extends JpaRepository<VehicalCode,Long> {

    List<VehicalCode> findByOperationIsNullOrOperationNot(String val);
}
