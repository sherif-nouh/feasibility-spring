package com.feas.service.impl;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.YearlyVariableExpens;
import com.feas.domain.entity.dto.CalculatedYearlyVariableExpense;
import com.feas.persistence.repository.YearlyVariableExpensRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Sherif Nouh
 * @Date ١٩/٠٣/٢٠٢٣
 */
@Service
public class YearlyVariableExpensService {

    private final YearlyVariableExpensRepository yearlyVariableExpensRepository;
    private final EconomicalStudySummaryService economicalStudySummaryService;

    public YearlyVariableExpensService(YearlyVariableExpensRepository yearlyVariableExpensRepository, EconomicalStudySummaryService economicalStudySummaryService) {
        this.yearlyVariableExpensRepository = yearlyVariableExpensRepository;
        this.economicalStudySummaryService = economicalStudySummaryService;
    }


    public YearlyVariableExpens gelAllYearlyVariableExpensByRequestAndLicence(long requestNumberIf,long licenseNumberIf){

        YearlyVariableExpens yvr = yearlyVariableExpensRepository.findFirstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc(requestNumberIf, licenseNumberIf);
      if(yvr!=null) {
          CalculatedYearlyVariableExpense calculatedYearlyVariableExpense = yearlyVariableExpensRepository.getCalculatedYearlyVariableExpense(licenseNumberIf, requestNumberIf);
          if(calculatedYearlyVariableExpense!=null){
              yvr.setTotal5Perc(calculatedYearlyVariableExpense.getTotal5Perc());

              yvr.setIndirectLabour(yearlyVariableExpensRepository.getDirectLaborSalarCy(requestNumberIf).multiply(yvr.getAliwDirectLaborCy().divide(new BigDecimal(100),3, RoundingMode.HALF_EVEN)));
              yvr.setTotalMaintenance(calculatedYearlyVariableExpense.getTotalMaintenance());
             // firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setYearlyVariableExpenses(calculatedYearlyVariableExpense.getYearlyVariableExpenses());
          }
          BigDecimal rawMatCovPackCy = yearlyVariableExpensRepository.getRawMatCovPackCy(requestNumberIf);
          BigDecimal directLaborSalaryCy =   yearlyVariableExpensRepository.getDirectLaborSalarCy(requestNumberIf);
          BigDecimal genProdFacUtiCyQuery = yearlyVariableExpensRepository.genProdFacUtiCyQuery(requestNumberIf);

          if(rawMatCovPackCy!=null){
              yvr.setRawMatCovPackCy(rawMatCovPackCy);
          }
          if(directLaborSalaryCy!=null){
              yvr.setDirectLaborSalarCy(directLaborSalaryCy);
          }
          if(genProdFacUtiCyQuery!=null){
              yvr.setGenProdFacUtiCy(genProdFacUtiCyQuery);
          }

          yvr.setYearlyVariableExpenses(
                  ( yvr.getRawMatCovPackCy() == null ? new BigDecimal(0) : yvr.getRawMatCovPackCy() )
                          .add(yearlyVariableExpensRepository.getDirectLaborSalarCy(requestNumberIf))
                          .add(yvr.getIndirectLabour())
                          .add(( yvr.getEmpInsuCy() == null ? new BigDecimal(0) : yvr.getEmpInsuCy() ))
                          .add(yvr.getGenProdFacUtiCy())
                          .add(yvr.getPrintStatCy())
                          .add(yvr.getTotalMaintenance())
                          .add(yvr.getTotal5Perc()));
          return yvr;
      }
      return null;
    }

    public YearlyVariableExpens saveYearlyVariableExpense(YearlyVariableExpens yearlyVariableExpens){
        YearlyVariableExpens saveObj=null;
       if(yearlyVariableExpens!=null) {
           YearlyVariableExpens firstByRequestAndLicense = yearlyVariableExpensRepository.findFirstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc(yearlyVariableExpens.getRequestNumberIf(), yearlyVariableExpens.getLicenseNumberIf());
                    if(firstByRequestAndLicense!=null){
                        firstByRequestAndLicense.setAliwDirectLaborCy(yearlyVariableExpens.getAliwDirectLaborCy());
                        firstByRequestAndLicense.setPercMaintBuildProjCy(yearlyVariableExpens.getPercMaintBuildProjCy());
                        firstByRequestAndLicense.setMaintSparesEquipCy(yearlyVariableExpens.getMaintSparesEquipCy());
                        firstByRequestAndLicense.setPrintStatCy(yearlyVariableExpens.getPrintStatCy());
                         saveObj = yearlyVariableExpensRepository.save(firstByRequestAndLicense);
                    }

           EconomicalStudySummary economicalStudySummaryOrCreateNew = economicalStudySummaryService.getEconomicalStudySummaryOrCreateNew(yearlyVariableExpens.getRequestNumberIf(), yearlyVariableExpens.getLicenseNumberIf());
           economicalStudySummaryOrCreateNew.setTYrVarExpCy(yearlyVariableExpens.getYearlyVariableExpenses());
           economicalStudySummaryService.save(economicalStudySummaryOrCreateNew);
       }
       return saveObj;
    }


}
