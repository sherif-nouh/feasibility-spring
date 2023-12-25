package com.feas.service.impl;

import com.feas.domain.config.CheckUtils;
import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.YearlyVariableExpens;
import com.feas.domain.entity.dto.YearlyFixedVariableExpense;
import com.feas.domain.entity.dto.YearlyFixedVariableExpenseDTO;
import com.feas.persistence.repository.YearlyDepreciationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٣٠/٠٧/٢٠٢٣
 */
@Service
public class YearlyFixedVariableExpService {
    private final YearlyDepreciationRepository yearlyDepreciationRepository;
    private final EconomicalStudySummaryService economicalStudySummaryService;

    public YearlyFixedVariableExpService(YearlyDepreciationRepository yearlyDepreciationRepository, EconomicalStudySummaryService economicalStudySummaryService) {
        this.yearlyDepreciationRepository = yearlyDepreciationRepository;
        this.economicalStudySummaryService = economicalStudySummaryService;
    }



    public YearlyFixedVariableExpenseDTO getYearlyFixedVariableExpenseDTO(BigDecimal requestNumberId,  BigDecimal licenseNumberId ){
        YearlyFixedVariableExpense yearlyFixedVariableExpense = yearlyDepreciationRepository.getYearlyFixedVariableExpense(requestNumberId, licenseNumberId);
        YearlyFixedVariableExpenseDTO yearlyFixedVariableExpenseDTO = calculateYearlyFixedVariableExpense(yearlyFixedVariableExpense);
        return yearlyFixedVariableExpenseDTO;
    }


    private YearlyFixedVariableExpenseDTO calculateYearlyFixedVariableExpense(YearlyFixedVariableExpense yearlyFixedVariableExpense){
        YearlyFixedVariableExpenseDTO yearlyFixedVariableExpenseDTO=null;
        if(yearlyFixedVariableExpense!=null){
            yearlyFixedVariableExpenseDTO=YearlyFixedVariableExpenseDTO
                    .builder().yearlyvariableexpensescost(yearlyFixedVariableExpense.getYearlyvariableexpensescost())
                    .tyrdepcy(yearlyFixedVariableExpense.getTyrdepcy())
                    .buildingconstructioncost(yearlyFixedVariableExpense.getBuildingconstructioncost())
                    .buildingmaintenancecost(yearlyFixedVariableExpense.getBuildingmaintenancecost())
                    .fixedequipmentcost(yearlyFixedVariableExpense.getFixedequipmentcost())
                    .yearlyspareequipmentcost(yearlyFixedVariableExpense.getYearlyspareequipmentcost())
                    .tyrfixedexpcy(yearlyFixedVariableExpense.getTyrfixedexpcy())
                    .licenseNumberIf(yearlyFixedVariableExpense.getLicenseNumberIf())
                    .requestnumberif(yearlyFixedVariableExpense.getRequestnumberif())
                    .build();

            yearlyFixedVariableExpenseDTO.setFixedexpenses(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getFixedexpenses())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getFixedexpenses());
            yearlyFixedVariableExpenseDTO.setTyrdepcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getTyrdepcy())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getTyrdepcy());
            yearlyFixedVariableExpenseDTO.setTyrvarexpcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getTyrvarexpcy())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getTyrvarexpcy());
            yearlyFixedVariableExpenseDTO.setTyrfixedexpcy(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getTyrfixedexpcy())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getTyrfixedexpcy());
            yearlyFixedVariableExpenseDTO.setYearlyspareequipmentcost(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getYearlyspareequipmentcost())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getYearlyspareequipmentcost());

            yearlyFixedVariableExpenseDTO.
                    setAnnualexpenses(yearlyFixedVariableExpenseDTO.getTyrfixedexpcy().add(yearlyFixedVariableExpenseDTO.getTyrdepcy()));



            yearlyFixedVariableExpenseDTO
                    .setFixedexpenses(yearlyFixedVariableExpenseDTO.getTyrfixedexpcy().add(yearlyFixedVariableExpenseDTO.getTyrdepcy()));

            yearlyFixedVariableExpenseDTO.setTyrvarexpcy( yearlyFixedVariableExpenseDTO.getYearlyvariableexpensescost()
                    .add(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getBuildingconstructioncost())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getBuildingconstructioncost()
                            .multiply(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getBuildingmaintenancecost())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getBuildingmaintenancecost()
                                    .divide(new BigDecimal(100))).add(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getFixedequipmentcost())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getFixedequipmentcost()
                                    .multiply(CheckUtils.isNullOrZero(yearlyFixedVariableExpenseDTO.getYearlyspareequipmentcost())?new BigDecimal(0):yearlyFixedVariableExpenseDTO.getYearlyspareequipmentcost()
                                            .divide(new BigDecimal(100))))));
            yearlyFixedVariableExpenseDTO
                    .setVariableexpenses(yearlyFixedVariableExpenseDTO.getAnnualexpenses().add(yearlyFixedVariableExpenseDTO.getTyrvarexpcy()));

        }
        return yearlyFixedVariableExpenseDTO;
    }


    public EconomicalStudySummary saveYearlyFixedVariableExpExpense(YearlyFixedVariableExpenseDTO yearlyFixedVariableExpenseDTO) {
        EconomicalStudySummary economicalStudySummaryOrCreateNew=null;
        if(yearlyFixedVariableExpenseDTO!=null) {
             economicalStudySummaryOrCreateNew = economicalStudySummaryService.getEconomicalStudySummaryOrCreateNew(yearlyFixedVariableExpenseDTO.getRequestnumberif(), yearlyFixedVariableExpenseDTO.getLicenseNumberIf());
            economicalStudySummaryOrCreateNew.setTYrFixedExpCy(yearlyFixedVariableExpenseDTO.getTyrfixedexpcy());
        }
        return economicalStudySummaryOrCreateNew;
    }
}

