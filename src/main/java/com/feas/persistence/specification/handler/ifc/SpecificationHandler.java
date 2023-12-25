package com.feas.persistence.specification.handler.ifc;

import org.springframework.data.jpa.domain.Specification;

import com.feas.persistence.specification.filter.FilterList;

public interface SpecificationHandler<T> {

     Specification<T> getFilterSpecification(FilterList filterList) ;

}
