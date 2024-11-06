package com.feas.persistence.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.feas.domain.entity.lookups.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByOperationIsNullOrOperationNot(String val);

}
