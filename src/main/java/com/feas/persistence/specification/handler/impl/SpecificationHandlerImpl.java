package com.feas.persistence.specification.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.feas.persistence.specification.handler.ifc.SpecificationHandler;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;


@Component
public class SpecificationHandlerImpl<T>  {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpecificationHandler.class);

   /* @Override
    public Specification<T> getFilterSpecification(FilterList filterList) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Optional<Predicate> predicate = filterList.getNonNullFilters().stream()
                    .filter(v -> v.getKey() != null && v.getKey().length() > 0 && v.getOperation() != null)
                    .map(criteria -> {
                        try {
                            // to handle eq & neq in case of booleans
                            Boolean value = "true".equalsIgnoreCase(criteria.getValue()) ? Boolean.TRUE :
                                    "false".equalsIgnoreCase(criteria.getValue()) ? Boolean.FALSE : null;

                            if (criteria.getOperation().equals(Operation.EQ)) {
                                if (value != null) {
                                    return builder.equal(
                                            root.get(criteria.getKey()), value);
                                } else {
                                    return builder.equal(
                                            root.get(criteria.getKey()), criteria.getValue());
                                }
                            } else if (criteria.getOperation().equals(Operation.NEQ)) {
                                if (value != null) {
                                    return builder.notEqual(
                                            root.get(criteria.getKey()), value);
                                } else {
                                    return builder.notEqual(
                                            root.get(criteria.getKey()), criteria.getValue());
                                }
                            } else if (criteria.getOperation().equals(Operation.CONTAINS)) {
                                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                                    return builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toLowerCase() + "%");
                                } else {
                                    return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                                }
                            } else if (criteria.getOperation().equals(Operation.LT)) {
                                return builder.lessThan(
                                        root.get(criteria.getKey()), criteria.getValue());
                            } else if (criteria.getOperation().equals(Operation.LTE)) {
                                return builder.lessThanOrEqualTo(
                                        root.get(criteria.getKey()), criteria.getValue());
                            } else if (criteria.getOperation().equals(Operation.GT)) {
                                return builder.greaterThan(
                                        root.get(criteria.getKey()), criteria.getValue());
                            } else if (criteria.getOperation().equals(Operation.GTE)) {
                                return builder.greaterThanOrEqualTo(
                                        root.get(criteria.getKey()), criteria.getValue());
                            } else if (criteria.getOperation().equals(Operation.STARTSWITH)) {
                                return builder.like(
                                        root.get(criteria.getKey()), criteria.getValue() + "%");
                            } else if (criteria.getOperation().equals(Operation.ENDSWITH)) {
                                return builder.like(
                                        root.get(criteria.getKey()), "%" + criteria.getValue());
                            } else if (criteria.getOperation().equals(Operation.NULL)) {
                                return builder.isNull(
                                        root.get(criteria.getKey()));
                            } else if (criteria.getOperation().equals(Operation.NOTNULL)) {
                                return builder.isNotNull(
                                        root.get(criteria.getKey()));
                            } else if (criteria.getOperation().equals(Operation.EMPTY)) {
                                return builder.isEmpty(
                                        root.get(criteria.getKey()));
                            } else if (criteria.getOperation().equals(Operation.NOTEMPTY)) {
                                return builder.isNotEmpty(
                                        root.get(criteria.getKey()));
                            } else if (criteria.getOperation().equals(Operation.IN)) {
                                String value1 = criteria.getValue();
                                if (value1.contains("[") || value1.contains("]")) {
                                    value1 = criteria.getValue().replaceAll("\\[", "").replaceAll("]", "");
                                }
                                String[] splitArray = value1.split(",");
                                List<Long> casted = new ArrayList<>();
                                Class<?> javaType = root.get(criteria.getKey()).getJavaType();
                                if(javaType.equals(Long.class)) {
                                    for (String element :splitArray){
                                        casted.add(Long.valueOf(element));
                                    }
                                  return builder.in(root.get(criteria.getKey())).value(casted);
                                }
                                return builder.in(root.get(criteria.getKey())).value(splitArray);
                            }else if (criteria.getOperation().equals(Operation.NOTIN)) {
                                String[] splitArray = criteria.getValue().split(",");
                                List<Long> casted = new ArrayList<>();
                                Class<?> javaType = root.get(criteria.getKey()).getJavaType();
                                if(javaType.equals(Long.class)) {
                                    for (String element :splitArray){
                                        casted.add(Long.valueOf(element));
                                    }
                                    return builder.not(root.get(criteria.getKey()).in(casted));
                                }
                                return builder.not(root.get(criteria.getKey()).in(splitArray));
                            } else {
                                return null;
                            }

                        } catch (Exception e) {
                            LOGGER.error(e.getLocalizedMessage(), e);
                            return null;
                        }
                    })
                    .reduce(filterList.applyAndOperation() ?
                            builder::and
                            : builder::or);
            return predicate.orElseGet(() -> alwaysTrue(builder));
        };
    }*/

    private Predicate alwaysTrue(CriteriaBuilder builder) {
        return builder.isTrue(builder.literal(true));
    }

}
