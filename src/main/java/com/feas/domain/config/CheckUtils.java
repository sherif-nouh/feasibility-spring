package com.feas.domain.config;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٣١/٠٧/٢٠٢٣
 */
public class CheckUtils {
    public static boolean isNullOrZero(BigDecimal number) {
        boolean isBigDecimalValueNullOrZero = false;
        if (number == null)
            isBigDecimalValueNullOrZero = true;
        else if (number != null && number.compareTo(BigDecimal.ZERO) == 0)
            isBigDecimalValueNullOrZero = true;

        return isBigDecimalValueNullOrZero;
    }

}
