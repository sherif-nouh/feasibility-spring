package com.feas.persistence.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feas.domain.entity.lookups.EquipCategory;

public interface EquipCategoryRepository extends JpaRepository<EquipCategory, Long> {

}
