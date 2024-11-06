package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.Manpower;
import com.feas.domain.entity.lookups.VehicalCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
public interface ManpowerRepository extends JpaRepository<Manpower,Long> {

    List<Manpower> findByOperationIsNullOrOperationNot(String val);

}
