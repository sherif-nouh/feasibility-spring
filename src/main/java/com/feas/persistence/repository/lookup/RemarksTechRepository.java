package com.feas.persistence.repository.lookup;

import com.feas.domain.entity.lookups.RemarksTech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٦/٢٠٢٣
 */
public interface RemarksTechRepository extends JpaRepository<RemarksTech, Long> {


   List<RemarksTech> findByLicenseNumberIfAndRequestNumberIf(Long licenseNumberIf, Long requestNumberIf);
}
