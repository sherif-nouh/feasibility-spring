package com.feas.persistence.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feas.domain.entity.lookups.EquipmentCode;

public interface EquipmentCodeRepository extends JpaRepository<EquipmentCode, Long> {

}
