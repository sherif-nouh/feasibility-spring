package com.feas.persistence.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feas.domain.entity.lookups.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	
}
