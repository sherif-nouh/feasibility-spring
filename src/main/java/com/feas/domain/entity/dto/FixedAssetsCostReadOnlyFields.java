package com.feas.domain.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ١٢/٠٣/٢٠٢٣
 */
public interface FixedAssetsCostReadOnlyFields {

    public long getProjectNumberIf();

    public long getRequestNumberIf() ;

    public long getLicenseNumberIf() ;

    public BigDecimal getCostOfAirCondCy() ;

    public BigDecimal getCostOfBuildConstCy() ;

    public BigDecimal getCostOfEquipCy() ;

    public BigDecimal getCostOfExtTranspVehCy() ;

    public BigDecimal getCostOfFurnCy();

    public BigDecimal getCostOfIntTranspVehCy() ;

    public BigDecimal getCostOfSpartsCy() ;

    public BigDecimal getCostofstoreprepcy() ;

    public BigDecimal getOtherCostCy() ;

    public BigDecimal getFixedAssetsTotalCost() ;

    public BigDecimal getEquipmentCost() ;

    public BigDecimal getCbuild();
    public BigDecimal getTvali() ;
    public BigDecimal getTvale() ;
    public BigDecimal getTotalCost() ;
    public String getUserName();

}
