package com.feas.domain.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Optional;

@SuppressWarnings("unused")
public class SequenceGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj)
            throws HibernateException {

        String query = String.format("select max(%s) from %s",
                convertCamelToSnake(session.getEntityPersister(obj.getClass().getName(), obj).getIdentifierPropertyName()),
                convertCamelToSnake(obj.getClass().getSimpleName()));
        System.out.println(query);
        Optional<BigDecimal> optionalMin = session.createNativeQuery(query).uniqueResultOptional();
        if(optionalMin.isPresent()) {
        	Long max=optionalMin.get().longValue();
        	return max+1;
        }
		return 1L;
        
    }
    
    private String convertCamelToSnake(String s) {
    	return s.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
    }

}
