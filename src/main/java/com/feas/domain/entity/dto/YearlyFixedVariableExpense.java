package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٣/٢٠٢٣
 */
public interface YearlyFixedVariableExpense {
    public long getLicenseNumberIf() ;

    public long getRequestnumberif() ;

    public BigDecimal getTyrdepcy() ;

    public BigDecimal getYearlyvariableexpensescost() ;


    public BigDecimal getBuildingconstructioncost() ;

    public BigDecimal getBuildingmaintenancecost();

    public BigDecimal getFixedequipmentcost() ;

    public BigDecimal getYearlyspareequipmentcost() ;

    public BigDecimal getTyrfixedexpcy() ;

    public BigDecimal getAnnualexpenses() ;

    public BigDecimal getVariableexpenses() ;

    public BigDecimal getFixedexpenses() ;


    public BigDecimal getTyrvarexpcy() ;

    public BigDecimal getPercdepbuildconstcy() ;

    public BigDecimal getDepbuildconstcy() ;

    public BigDecimal getPercdepequipainstcy() ;

    public BigDecimal getDepequipafterinstalcy() ;

    public BigDecimal getPercdepaircondcy() ;

    public BigDecimal getDepaircondcy();

    public BigDecimal getPercdepofficefurcy() ;
    public BigDecimal getDepofofffurcy() ;

    public BigDecimal getPercdepoffurwahousecy();

    public BigDecimal getDepoffurforwahousecy() ;

    public BigDecimal getPercdepexttranspcy() ;

    public BigDecimal getDepofexttranspcy() ;

    public BigDecimal getPercdepinttranspcy() ;

    public BigDecimal getDepinttranspcy() ;

    public BigDecimal getOtherdepcy() ;

    public String getUsername() ;

    public String getOperation() ;

    public BigDecimal getBuilding();

    public BigDecimal getEquipment() ;

    public BigDecimal getAircondition() ;

    public BigDecimal getFurniture() ;

    public BigDecimal getStore();

    public BigDecimal getEvehicle() ;

    public BigDecimal getIvehicle() ;

    public BigDecimal getYealrydepreciationvalue() ;

}
