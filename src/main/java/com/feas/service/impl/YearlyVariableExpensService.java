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

        YearlyVariableExpens firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc = yearlyVariableExpensRepository.findFirstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc(requestNumberIf, licenseNumberIf);
      if(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc!=null) {
          CalculatedYearlyVariableExpense calculatedYearlyVariableExpense = yearlyVariableExpensRepository.getCalculatedYearlyVariableExpense(licenseNumberIf, requestNumberIf);
          if(calculatedYearlyVariableExpense!=null){
              firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setTotal5Perc(calculatedYearlyVariableExpense.getTotal5Perc());

              firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setIndirectLabour(yearlyVariableExpensRepository.getDirectLaborSalarCy(requestNumberIf).multiply(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getAliwDirectLaborCy().divide(new BigDecimal(100),3, RoundingMode.HALF_EVEN)));
              firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setTotalMaintenance(calculatedYearlyVariableExpense.getTotalMaintenance());
             // firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setYearlyVariableExpenses(calculatedYearlyVariableExpense.getYearlyVariableExpenses());
          }
          BigDecimal rawMatCovPackCy = yearlyVariableExpensRepository.getRawMatCovPackCy(requestNumberIf);
          BigDecimal directLaborSalaryCy =   yearlyVariableExpensRepository.getDirectLaborSalarCy(requestNumberIf);
          BigDecimal genProdFacUtiCyQuery = yearlyVariableExpensRepository.genProdFacUtiCyQuery(requestNumberIf);

          if(rawMatCovPackCy!=null){
              firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setRawMatCovPackCy(rawMatCovPackCy);
          }
          if(directLaborSalaryCy!=null){
              firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setDirectLaborSalarCy(directLaborSalaryCy);
          }
          if(genProdFacUtiCyQuery!=null){
              firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setGenProdFacUtiCy(genProdFacUtiCyQuery);
          }

          firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.setYearlyVariableExpenses(
                  firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getRawMatCovPackCy()
                          .add(yearlyVariableExpensRepository.getDirectLaborSalarCy(requestNumberIf))
                          .add(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getIndirectLabour())
                          .add(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getEmpInsuCy())
                          .add(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getGenProdFacUtiCy())
                          .add(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getPrintStatCy())
                          .add(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getTotalMaintenance())
                          .add(firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc.getTotal5Perc()));
          return firstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc;
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
