package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٧/٢٠٢٣
 */
public interface YearlyDepreciationCustom {
    public BigDecimal getProjectNumberIf() ;

    public BigDecimal getRequestNumberIf() ;

    public BigDecimal getPercDepBuildConstCy() ;

    public BigDecimal getDepBuildConstCy();


    public BigDecimal getPercdepEquipAInstCy() ;

    public BigDecimal getDepEquipAfterInstalCy() ;

    public BigDecimal getPercDepAirCondCy() ;

    public BigDecimal getDepAirCondCy() ;

    public BigDecimal getPercDepOfficeFurCy() ;

    public BigDecimal getDepOfOffFurCy() ;

    public BigDecimal getPercDepOfFurWahouseCy();

    public BigDecimal getDepOfFurForWahouseCy() ;

    public BigDecimal getPercDepExtTranspCy() ;

    public BigDecimal getDepOfExtTranspCy() ;

    public BigDecimal getPercDepIntTranspCy() ;

    public BigDecimal getDepIntTranspCy() ;

    public BigDecimal getOtherDepCy() ;

    public String getUserName() ;

    public String getOperation() ;

    public BigDecimal getLicenseNumberIf() ;

    public BigDecimal getYealryDepreciationValue() ;

    public BigDecimal getBuilding() ;

    public BigDecimal getEquipment() ;

    public BigDecimal getAirCondition() ;

    public BigDecimal getFurniture() ;

    public BigDecimal getStore() ;

    public BigDecimal getEVehicle() ;

    public BigDecimal getIVehicle();
}
