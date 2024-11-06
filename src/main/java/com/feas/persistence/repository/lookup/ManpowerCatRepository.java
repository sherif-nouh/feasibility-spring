package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.ManpowerCat;
import com.feas.domain.entity.lookups.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
public interface ManpowerCatRepository extends JpaRepository<ManpowerCat,Long> {

    List<ManpowerCat> findByOperationIsNullOrOperationNot(String d);
}
