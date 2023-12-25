package com.feas.service.impl;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.YearlyFixedExpens;
import com.feas.domain.entity.YearlyFixedExpensPK;
import com.feas.domain.entity.dto.YearlyFixedExpensDTO;
import com.feas.domain.entity.dto.YearlyFixedExpensRequest;
import com.feas.domain.entity.dto.YearlyFixedExpensRequestDTO;
import com.feas.persistence.repository.YearlyFixedExpensRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٢/٢٠٢٣
 */
@Service
public class YearlyFixedExpensService {

 private final YearlyFixedExpensRepository yearlyFixedExpensRepository;
 private final EconomicalStudySummaryService economicalStudySummaryService;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public YearlyFixedExpensService(YearlyFixedExpensRepository yearlyFixedExpensRepository, EconomicalStudySummaryService economicalStudySummaryService, ServiceObjectMapperImpl modelMapper) {
        this.yearlyFixedExpensRepository = yearlyFixedExpensRepository;
        this.economicalStudySummaryService = economicalStudySummaryService;
        this.modelMapper = modelMapper;
    }

    public YearlyFixedExpensRequestDTO getYealyFixedExpense(BigDecimal requestNumberId, BigDecimal licenseNumberId){
        YearlyFixedExpensRequest yearlyFixedEx = yearlyFixedExpensRepository.getYealyFixedExpense(requestNumberId, licenseNumberId);

            YearlyFixedExpensRequestDTO yearlyFixedExpensRequestDTO=new YearlyFixedExpensRequestDTO();
            yearlyFixedExpensRequestDTO.setAdvertExpCy(yearlyFixedEx.getAdvertExpCy());
            yearlyFixedExpensRequestDTO.setInsuPercexpBuildtoolsCy(yearlyFixedEx.getInsuPercexpBuildtoolsCy());
            BigDecimal insurance = yearlyFixedExpensRepository.getInsurance(requestNumberId);
             insurance=insurance.multiply(yearlyFixedEx.getInsuPercexpBuildtoolsCy().divide(new BigDecimal(100),3,RoundingMode.HALF_UP));
            yearlyFixedExpensRequestDTO.setInsurance(insurance);
            yearlyFixedExpensRequestDTO.setDateStamp(yearlyFixedEx.getDateStamp());
            yearlyFixedExpensRequestDTO.setAuditExpCy(yearlyFixedEx.getAuditExpCy());
            yearlyFixedExpensRequestDTO.setTotalYearlyFixedExpenses(yearlyFixedEx.getTotalYearlyFixedExpenses());
            yearlyFixedExpensRequestDTO.setAllpercIndmanpCostCy(yearlyFixedEx.getAllpercIndmanpCostCy());
            yearlyFixedExpensRequestDTO.setIndSpaceRentCy(yearlyFixedEx.getIndSpaceRentCy());
            yearlyFixedExpensRequestDTO.setOperation(yearlyFixedEx.getOperation());
            yearlyFixedExpensRequestDTO.setSalariesCy(yearlyFixedExpensRepository.getSalariesCyField(requestNumberId));
            yearlyFixedExpensRequestDTO.setAllowancesCy(getAllowancesCy(yearlyFixedEx,requestNumberId));
            yearlyFixedExpensRequestDTO.setVehInsurCy(yearlyFixedEx.getVehInsurCy());
            yearlyFixedExpensRequestDTO.setUserName(yearlyFixedEx.getUserName());
            yearlyFixedExpensRequestDTO.setTrvlAllwConsultExpCy(yearlyFixedExpensRepository.getTrvlAllwConsultExpCy(requestNumberId));
            yearlyFixedExpensRequestDTO.setRequestNumberIf(yearlyFixedEx.getRequestNumberIf()==null?0L:yearlyFixedEx.getRequestNumberIf());
            yearlyFixedExpensRequestDTO.setProjectNumberIf(yearlyFixedEx.getProjectNumberIf());
            yearlyFixedExpensRequestDTO.setProfitsNotinclProdCy(yearlyFixedExpensRepository.getProfitsNotinclProdCy(requestNumberId));
            yearlyFixedExpensRequestDTO.setOtherExpCy(yearlyFixedEx.getOtherExpCy());
            yearlyFixedExpensRequestDTO.setNonroutineMaintExpCy(yearlyFixedEx.getNonroutineMaintExpCy());
            yearlyFixedExpensRequestDTO.setLicenseNumberIf(yearlyFixedEx.getLicenseNumberIf());
        BigDecimal genXpCy = insurance
                .add(yearlyFixedEx.getAuditExpCy()
                        .add(yearlyFixedEx.getAuditExpCy()
                                .add(yearlyFixedExpensRepository.getTrvlAllwConsultExpCy(requestNumberId)
                                        .add(yearlyFixedEx.getProfitsNotinclProdCy()
                                                .add(yearlyFixedEx.getVehInsurCy()
                                                        .add(yearlyFixedEx.getNonroutineMaintExpCy()
                                                                .add(getVariableExpensesValues(requestNumberId))))))))
                .divide(new BigDecimal(4), 3, RoundingMode.HALF_UP);

        yearlyFixedExpensRequestDTO.setGenExpCy(genXpCy);



        BigDecimal indSpecRentCY = (yearlyFixedExpensRequestDTO.getIndSpaceRentCy() != null) ? yearlyFixedExpensRequestDTO.getIndSpaceRentCy() : new BigDecimal(0) ;
        BigDecimal salaryCY  = (yearlyFixedExpensRequestDTO.getSalariesCy() !=null) ? yearlyFixedExpensRequestDTO.getSalariesCy() : new BigDecimal(0);
//        BigDecimal allowanceCY = (getAllowancesCy() != null) ? getAllowancesCy() : new BigDecimal(0) ;
        BigDecimal auditExpCY  = (yearlyFixedExpensRequestDTO.getAuditExpCy() !=null) ? yearlyFixedExpensRequestDTO.getAuditExpCy() : new BigDecimal(0);
        BigDecimal adverExpCY = (yearlyFixedExpensRequestDTO.getAdvertExpCy() != null) ? yearlyFixedExpensRequestDTO.getAdvertExpCy() : new BigDecimal(0) ;
        BigDecimal travelAllowanceConsltCY  = (yearlyFixedExpensRequestDTO.getTrvlAllwConsultExpCy() !=null) ? yearlyFixedExpensRequestDTO.getTrvlAllwConsultExpCy() : new BigDecimal(0);
        BigDecimal genExpCY = (yearlyFixedExpensRequestDTO.getGenExpCy() != null) ? yearlyFixedExpensRequestDTO.getGenExpCy() : new BigDecimal(0) ;
        BigDecimal profit  = (yearlyFixedExpensRequestDTO.getProfitsNotinclProdCy() !=null) ? yearlyFixedExpensRequestDTO.getProfitsNotinclProdCy() : new BigDecimal(0);

        BigDecimal vehicleInst  = (yearlyFixedExpensRequestDTO.getVehInsurCy() !=null) ? yearlyFixedExpensRequestDTO.getVehInsurCy() : new BigDecimal(0);
        BigDecimal nonroutineMaintExpCy = (yearlyFixedExpensRequestDTO.getNonroutineMaintExpCy() != null) ? yearlyFixedExpensRequestDTO.getNonroutineMaintExpCy() : new BigDecimal(0) ;
        BigDecimal insuranceV  = (yearlyFixedExpensRequestDTO.getInsurance() !=null) ? yearlyFixedExpensRequestDTO.getInsurance() : new BigDecimal(0);

        BigDecimal totalYearlyFixedExpenses =indSpecRentCY
                .add(salaryCY
                        .add(yearlyFixedEx.getAllowancesCy() //we need the allawances without calculation here   the above as getAllowancesCy() is not getting calculated in total yearly fixed value.
                                .add(auditExpCY.add(adverExpCY
                                        .add(travelAllowanceConsltCY
                                                .add(genExpCY
                                                        .add(profit.add(vehicleInst
                                                                .add(nonroutineMaintExpCy.add(insuranceV))))))))));


         yearlyFixedExpensRequestDTO.setTotalYearlyFixedExpenses(totalYearlyFixedExpenses);

        return  yearlyFixedExpensRequestDTO;
    }

     private BigDecimal getAllowancesCy(YearlyFixedExpensRequest yearlyFixedEx,BigDecimal request){

         return yearlyFixedEx.getAllpercIndmanpCostCy().divide(new BigDecimal(100),3, RoundingMode.HALF_UP).multiply(yearlyFixedExpensRepository.getSalariesCyField(request));

    }



    public Optional<YearlyFixedExpens> findById(YearlyFixedExpensPK id) {
        return yearlyFixedExpensRepository.findById(id);
    }

    public YearlyFixedExpens save(YearlyFixedExpensDTO yearlyFixedExpensDTO) {
        YearlyFixedExpensPK yearlyFixedExpensPK=new YearlyFixedExpensPK();
        yearlyFixedExpensPK.setLicenseNumberIf(yearlyFixedExpensDTO.getLicenseNumberIf());
        yearlyFixedExpensPK.setRequestNumberIf(yearlyFixedExpensDTO.getRequestNumberIf());
        yearlyFixedExpensPK.setProjectNumberIf(yearlyFixedExpensDTO.getLicenseNumberIf());
        YearlyFixedExpens prop = yearlyFixedExpensRepository.findById(yearlyFixedExpensPK).get();
        if(yearlyFixedExpensDTO.getIndSpaceRentCy()!=null){
            prop.setIndSpaceRentCy(yearlyFixedExpensDTO.getIndSpaceRentCy());
        }
        if(yearlyFixedExpensDTO.getAllpercIndmanpCostCy()!=null){
            prop.setAllpercIndmanpCostCy(yearlyFixedExpensDTO.getAllpercIndmanpCostCy());
        }
        if(yearlyFixedExpensDTO.getInsuPercexpBuildtoolsCy()!=null){
            prop.setInsuPercexpBuildtoolsCy(yearlyFixedExpensDTO.getInsuPercexpBuildtoolsCy());
        }
        if(yearlyFixedExpensDTO.getAuditExpCy()!=null){
            prop.setAuditExpCy(yearlyFixedExpensDTO.getAuditExpCy());
        }
        if(yearlyFixedExpensDTO.getAdvertExpCy()!=null){
            prop.setAdvertExpCy(yearlyFixedExpensDTO.getAdvertExpCy());
        }
        if(yearlyFixedExpensDTO.getVehInsurCy()!=null){
            prop.setVehInsurCy(yearlyFixedExpensDTO.getVehInsurCy());
        }
        if(yearlyFixedExpensDTO.getNonroutineMaintExpCy()!=null){
            prop.setNonroutineMaintExpCy(yearlyFixedExpensDTO.getNonroutineMaintExpCy());
        }
        EconomicalStudySummary economicalStudySummaryOrCreateNew = economicalStudySummaryService.getEconomicalStudySummaryOrCreateNew(yearlyFixedExpensDTO.getRequestNumberIf(), yearlyFixedExpensDTO.getLicenseNumberIf());
        economicalStudySummaryOrCreateNew.setTYrFixedExpCy(yearlyFixedExpensDTO.getTotalYearlyFixedExpenses());
        economicalStudySummaryService.save(economicalStudySummaryOrCreateNew);

        return yearlyFixedExpensRepository.save(prop);
    }


     private BigDecimal getVariableExpensesValues(BigDecimal requestNumberId){
         BigDecimal V_NUM1 = yearlyFixedExpensRepository.generalFacilityQuery(requestNumberId);
         List<Object[]> yearlyVariableExpenseQuery = yearlyFixedExpensRepository.yearlyVariableExpenseQuery(requestNumberId);
         BigDecimal V_NUM2=new BigDecimal(0);
         BigDecimal V_NUM3=new BigDecimal(0);
         BigDecimal V_NUM4=new BigDecimal(0);
         for(Object[] row: yearlyVariableExpenseQuery){
               V_NUM2 =(BigDecimal) row[0];
              V_NUM3 =(BigDecimal) row[1];
              V_NUM4 =(BigDecimal) row[2];
         }
         V_NUM3 = V_NUM3.divide(new BigDecimal(1), 0, RoundingMode.HALF_EVEN);
         V_NUM4 = V_NUM4.divide(new BigDecimal(1), 0, RoundingMode.HALF_EVEN);

         BigDecimal V_NUM5 = yearlyFixedExpensRepository.fixedAssetCostQuery1(requestNumberId);
          V_NUM5 = V_NUM5.divide(new BigDecimal(1), 0, RoundingMode.HALF_EVEN);

         BigDecimal V_NUM6 = yearlyFixedExpensRepository.fixedAssetCostQuery2(requestNumberId);
         V_NUM6 = V_NUM6.divide(new BigDecimal(1), 0, RoundingMode.HALF_EVEN);

         BigDecimal V_TOT1=V_NUM1;
         BigDecimal V_TOT2=V_NUM2;
         BigDecimal V_TOT3= (V_NUM3.multiply(V_NUM5)).divide(new BigDecimal(100),3,RoundingMode.HALF_EVEN);
         BigDecimal V_TOT4=(V_NUM6.multiply(V_NUM4)).divide(new BigDecimal(100),3,RoundingMode.HALF_EVEN);

         V_TOT3 = V_TOT3.divide(new BigDecimal(1), 0, RoundingMode.HALF_EVEN);
         V_TOT4 = V_TOT4.divide(new BigDecimal(1), 0, RoundingMode.HALF_EVEN);
         return V_TOT1.add(V_TOT2.add(V_TOT3.add(V_TOT4)));
     }
}
