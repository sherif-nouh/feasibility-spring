package com.feas.persistence.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feas.domain.entity.lookups.ForeignCurrency;

public interface ForeignCurrencyRepository extends JpaRepository<ForeignCurrency, Long> {

}
