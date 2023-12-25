package com.feas.service.impl;

import com.feas.domain.config.CheckUtils;
import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.YearlyDepreciation;
import com.feas.domain.entity.YearlyDepreciationPK;
import com.feas.domain.entity.dto.YearlyDepreciationCustom;
import com.feas.domain.entity.dto.YearlyFixedVariableExpense;
import com.feas.domain.entity.dto.YearlyFixedVariableExpenseDTO;
import com.feas.persistence.repository.YearlyDepreciationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Service
public class YearlyDepreciationService {

    private final YearlyDepreciationRepository yearlyDepreciationRepository;
    private final EconomicalStudySummaryService economicalStudySummaryService;

    public YearlyDepreciationService(YearlyDepreciationRepository yearlyDepreciationRepository, EconomicalStudySummaryService economicalStudySummaryService) {
        this.yearlyDepreciationRepository = yearlyDepreciationRepository;
        this.economicalStudySummaryService = economicalStudySummaryService;
    }

    public YearlyFixedVariableExpenseDTO getYearlyFixedVariableExpense(BigDecimal requestNumberId,BigDecimal licenseNumberId){
        YearlyFixedVariableExpense yearlyFixedVariableExpense = yearlyDepreciationRepository.getYearlyDepreciationByLicAndReq(requestNumberId.longValue(), licenseNumberId.longValue());
        YearlyFixedVariableExpenseDTO obj=new YearlyFixedVariableExpenseDTO();

        if(yearlyFixedVariableExpense!=null) {

            if(yearlyFixedVariableExpense.getYearlyvariableexpensescost()!=null&&yearlyFixedVariableExpense.getBuildingconstructioncost()!=null&&yearlyFixedVariableExpense.getBuildingmaintenancecost()!=null) {
                obj.setTyrvarexpcy(yearlyFixedVariableExpense.getYearlyvariableexpensescost()
                        .add(yearlyFixedVariableExpense.getBuildingconstructioncost()
                                .multiply(yearlyFixedVariableExpense.getBuildingmaintenancecost()
                                        .divide(new BigDecimal(100))).add(yearlyFixedVariableExpense.getFixedequipmentcost()
                                        .multiply(yearlyFixedVariableExpense.getYearlyspareequipmentcost()
                                                .divide(new BigDecimal(100))))));
            }
            obj.setBuilding(yearlyFixedVariableExpense.getBuilding());
            obj.setEquipment(yearlyFixedVariableExpense.getEquipment());
            obj.setAircondition(yearlyFixedVariableExpense.getAircondition());
            obj.setFurniture(yearlyFixedVariableExpense.getFurniture());
            obj.setLicenseNumberIf(yearlyFixedVariableExpense.getLicenseNumberIf());
            obj.setRequestnumberif(yearlyFixedVariableExpense.getRequestnumberif());
            obj.setYealrydepreciationvalue(null==yearlyFixedVariableExpense.getYealrydepreciationvalue()?BigDecimal.ZERO:yearlyFixedVariableExpense.getYealrydepreciationvalue());
             // obj.setVariableExpenses(obj.getAnnualExpenses().add( obj.getTYrVarExpCy()));
            obj.setEvehicle(null==yearlyFixedVariableExpense.getEvehicle()?BigDecimal.ZERO:yearlyFixedVariableExpense.getEvehicle());
            obj.setIvehicle(null==yearlyFixedVariableExpense.getIvehicle()?BigDecimal.ZERO:yearlyFixedVariableExpense.getIvehicle());
            obj.setYearlyvariableexpensescost(null==yearlyFixedVariableExpense.getYearlyvariableexpensescost()?BigDecimal.ZERO:yearlyFixedVariableExpense.getYearlyvariableexpensescost());
            obj.setTyrfixedexpcy(null==yearlyFixedVariableExpense.getTyrfixedexpcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getTyrfixedexpcy());
            obj.setFixedequipmentcost(null==yearlyFixedVariableExpense.getFixedequipmentcost()?BigDecimal.ZERO:yearlyFixedVariableExpense.getFixedequipmentcost());
            obj.setTyrdepcy(null==yearlyFixedVariableExpense.getTyrdepcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getTyrdepcy());
            obj.setBuildingconstructioncost(yearlyFixedVariableExpense.getBuildingconstructioncost());
            obj.setBuildingmaintenancecost(yearlyFixedVariableExpense.getBuildingmaintenancecost());
            obj.setYearlyspareequipmentcost(yearlyFixedVariableExpense.getYearlyspareequipmentcost());
            obj.setStore(null==yearlyFixedVariableExpense.getStore()?BigDecimal.ZERO:yearlyFixedVariableExpense.getStore());
            obj.setAnnualexpenses(obj.getTyrfixedexpcy().add(obj.getTyrdepcy()));
            obj.setFixedexpenses(obj.getTyrfixedexpcy().add(obj.getTyrdepcy()));
            obj.setTyrvarexpcy(null==yearlyFixedVariableExpense.getTyrvarexpcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getTyrvarexpcy());
            obj.setTyrfixedexpcy(null==yearlyFixedVariableExpense.getTyrfixedexpcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getTyrfixedexpcy());
            obj.setYearlyspareequipmentcost(null==yearlyFixedVariableExpense.getYearlyspareequipmentcost()?BigDecimal.ZERO:yearlyFixedVariableExpense.getYearlyspareequipmentcost());
            obj.setPercdepaircondcy(null==yearlyFixedVariableExpense.getPercdepaircondcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getPercdepaircondcy());
            obj.setPercdepofficefurcy(null==yearlyFixedVariableExpense.getPercdepofficefurcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getPercdepofficefurcy());
            obj.setPercdepinttranspcy(null==yearlyFixedVariableExpense.getPercdepinttranspcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getPercdepinttranspcy());
            obj.setPercdepbuildconstcy(null==yearlyFixedVariableExpense.getPercdepbuildconstcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getPercdepbuildconstcy());
            obj.setPercdepoffurwahousecy(null==yearlyFixedVariableExpense.getPercdepoffurwahousecy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getPercdepoffurwahousecy());
            obj.setPercdepexttranspcy(null==yearlyFixedVariableExpense.getPercdepexttranspcy()?BigDecimal.ZERO:yearlyFixedVariableExpense.getPercdepexttranspcy());
            obj.setPercdepinttranspcy( CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getPercdepinttranspcy())?new BigDecimal(0):yearlyFixedVariableExpense.getPercdepinttranspcy());
            obj.setDepinttranspcy(obj.getIvehicle().multiply(obj.getPercdepinttranspcy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP)));

            obj.setPercdepexttranspcy( CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getPercdepexttranspcy())?new BigDecimal(0):yearlyFixedVariableExpense.getPercdepexttranspcy());
            obj.setDepofexttranspcy(obj.getEvehicle().multiply(obj.getPercdepexttranspcy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP)));

            obj.setPercdepoffurwahousecy(CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getPercdepoffurwahousecy())?new BigDecimal(0):yearlyFixedVariableExpense.getPercdepoffurwahousecy());
            obj.setDepoffurforwahousecy( obj.getStore().multiply(obj.getPercdepoffurwahousecy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP)));

            obj.setPercdepofficefurcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getPercdepofficefurcy())?new BigDecimal(0):yearlyFixedVariableExpense.getPercdepofficefurcy());
            obj.setDepofofffurcy( yearlyFixedVariableExpense.getFurniture().multiply(obj.getPercdepofficefurcy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP)));

            obj.setPercdepaircondcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getPercdepaircondcy())?new BigDecimal(0):yearlyFixedVariableExpense.getPercdepaircondcy());
            obj.setDepaircondcy(yearlyFixedVariableExpense.getAircondition().multiply(obj.getPercdepaircondcy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP)));

            obj.setPercdepequipainstcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getPercdepequipainstcy())?new BigDecimal(0):yearlyFixedVariableExpense.getPercdepequipainstcy());
            obj.setDepequipafterinstalcy(yearlyFixedVariableExpense.getEquipment().multiply(obj.getPercdepequipainstcy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP)));

            obj.setPercdepbuildconstcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getPercdepbuildconstcy())?new BigDecimal(0):yearlyFixedVariableExpense.getPercdepbuildconstcy());
            obj.setDepbuildconstcy(yearlyFixedVariableExpense.getBuilding().multiply(obj.getPercdepbuildconstcy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP)));

            obj.setYealrydepreciationvalue(obj.getDepbuildconstcy()
                                                .add(obj.getDepaircondcy())
                                                 .add(obj.getDepequipafterinstalcy()).add(obj.getDepinttranspcy())
                    .add(obj.getDepofexttranspcy())
                    .add(obj.getDepoffurforwahousecy())
                    .add(obj.getDepofofffurcy())) ;
            //obj.setTyrfixedexpcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpense.getTyrfixedexpcy())?BigDecimal.ZERO:yearlyFixedVariableExpense.getTyrfixedexpcy());
        }
        return obj;
    }

    public YearlyFixedVariableExpenseDTO save(YearlyFixedVariableExpenseDTO yearlyFixedVariableExpenseDTO){
        if (yearlyFixedVariableExpenseDTO!=null) {

            EconomicalStudySummary economicalStudySummaryOrCreateNew = economicalStudySummaryService.getEconomicalStudySummaryOrCreateNew(yearlyFixedVariableExpenseDTO.getRequestnumberif(), yearlyFixedVariableExpenseDTO.getLicenseNumberIf());
            YearlyDepreciationPK yearlyDepreciationPK=new YearlyDepreciationPK();
            yearlyDepreciationPK.setLicenseNumberIf(yearlyFixedVariableExpenseDTO.getLicenseNumberIf());
            yearlyDepreciationPK.setProjectNumberIf(yearlyFixedVariableExpenseDTO.getLicenseNumberIf());
            yearlyDepreciationPK.setRequestNumberIf(yearlyFixedVariableExpenseDTO.getRequestnumberif());
            YearlyDepreciation yearlyDepreciationById = yearlyDepreciationRepository.findYearlyDepreciationById(yearlyDepreciationPK);
            EconomicalStudySummary save1=null;
            YearlyDepreciation save=null;
            if (economicalStudySummaryOrCreateNew != null) {
                economicalStudySummaryOrCreateNew.setTYrFixedExpCy(yearlyFixedVariableExpenseDTO.getTyrfixedexpcy());
                if(yearlyFixedVariableExpenseDTO.getYealrydepreciationvalue()!=null){
                    economicalStudySummaryOrCreateNew.setTYrDepCy(yearlyFixedVariableExpenseDTO.getYealrydepreciationvalue());
                }
                 save1 = economicalStudySummaryService.save(economicalStudySummaryOrCreateNew);

                if (yearlyDepreciationById!=null) {
                    YearlyDepreciation yearlyDepreciation = saveYearlyDept(yearlyFixedVariableExpenseDTO, yearlyDepreciationById);


                     save = yearlyDepreciationRepository.save(yearlyDepreciation);
                }

            }

            if(save1!=null&&save!=null){
                return yearlyFixedVariableExpenseDTO;
            }
            

        }
        return null;
    }


    public YearlyFixedVariableExpense getYearlyDepreciationByLicAndReq(long requestNumberId, long licenseNumberId){

      return yearlyDepreciationRepository.getYearlyDepreciationByLicAndReq(requestNumberId,licenseNumberId);
    }


    private YearlyDepreciation saveYearlyDept(YearlyFixedVariableExpenseDTO source,YearlyDepreciation destination){
        if(source!=null){
            destination.setDepAirCondCy(source.getDepaircondcy());
            destination.setDateStamp(new Date());
            destination.setDepBuildConstCy(source.getDepbuildconstcy());
            destination.setDepIntTranspCy(source.getDepinttranspcy());
            destination.setDepOfExtTranspCy(source.getDepofexttranspcy());
            destination.setDepOfOffFurCy(source.getDepofofffurcy());
            destination.setDepEquipAfterInstalCy(source.getDepequipafterinstalcy());
            destination.setDepOfFurForWahouseCy(source.getDepoffurforwahousecy());

            destination.setPercDepAirCondCy(source.getPercdepaircondcy());
            destination.setPercdepEquipAInstCy(source.getPercdepequipainstcy());
            destination.setPercDepBuildConstCy(source.getPercdepbuildconstcy());
            destination.setPercDepOfficeFurCy(source.getPercdepofficefurcy());
            destination.setPercDepIntTranspCy(source.getPercdepinttranspcy());
            destination.setPercDepExtTranspCy(source.getPercdepexttranspcy());
            destination.setPercDepOfFurWahouseCy(source.getPercdepoffurwahousecy());




        }
        return destination;
    }
}
