package com.feas.persistence.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feas.domain.entity.lookups.EquipmentType;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {

}
