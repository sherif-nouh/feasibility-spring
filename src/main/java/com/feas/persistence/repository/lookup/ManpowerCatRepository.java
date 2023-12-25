package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.ManpowerCat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
public interface ManpowerCatRepository extends JpaRepository<ManpowerCat,Long> {
}
