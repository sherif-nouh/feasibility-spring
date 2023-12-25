package com.feas.service.impl;

import com.feas.domain.entity.dto.BreakevenPointCustom;
import com.feas.domain.entity.dto.BreakevenPointCustomDTO;
import com.feas.persistence.repository.BreakevenPointRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٢/٢٠٢٣
 */

@Service
public class BreakevenPointService {

    private final BreakevenPointRepository breakevenPointRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public BreakevenPointService(BreakevenPointRepository breakevenPointRepository, ServiceObjectMapperImpl modelMapper) {
        this.breakevenPointRepository = breakevenPointRepository;
        this.modelMapper = modelMapper;
    }

    public BreakevenPointCustomDTO getBreakEvenPointCustomEntity(BigDecimal requestNumberId, BigDecimal licenseNumber){
        BreakevenPointCustom breakEvenPointCustomEntity = breakevenPointRepository.getBreakEvenPointCustomEntity(requestNumberId, licenseNumber);
        BreakevenPointCustomDTO breakevenPointCustomDTO= new BreakevenPointCustomDTO();
        breakevenPointCustomDTO.setIndProfit(breakEvenPointCustomEntity.getIndProfit());
        breakevenPointCustomDTO.setFixedAssets(breakEvenPointCustomEntity.getFixedAssets());
        breakevenPointCustomDTO.setWorkerNos(breakEvenPointCustomEntity.getWorkerNos());
        breakevenPointCustomDTO.setTotDeposit(breakEvenPointCustomEntity.getTotDeposit());
        breakevenPointCustomDTO.setYearlyDepreciation(breakEvenPointCustomEntity.getYearlyDepreciation());
        breakevenPointCustomDTO.setIndustrialProfitCY(breakEvenPointCustomEntity.getIndustrialProfitCY());
        breakevenPointCustomDTO.setYearlyProductionNR(breakEvenPointCustomEntity.getYearlyProductionNR());
        breakevenPointCustomDTO.setYearlySalesCY(breakEvenPointCustomEntity.getYearlySalesCY());
        breakevenPointCustomDTO.setProjectAddDepreciation(breakevenPointCustomDTO.getIndProfit().add(breakevenPointCustomDTO.getYearlyDepreciation()));
        if(breakevenPointCustomDTO.getTotDeposit()!=new BigDecimal(0)&&breakevenPointCustomDTO.getIndProfit()!=new BigDecimal(0)){
            BigDecimal projectAddDepreciation = breakevenPointCustomDTO.getProjectAddDepreciation();
            BigDecimal totDeposit = breakevenPointCustomDTO.getTotDeposit();
            BigDecimal divide = totDeposit.divide(projectAddDepreciation,3, RoundingMode.HALF_UP);
            breakevenPointCustomDTO.setPaybackPeriodTotInvCY(divide);
        }
        BigDecimal multiply = breakevenPointCustomDTO.getFixedAssets().multiply(breakevenPointCustomDTO.getYearlyProductionNR());
        if(multiply!=new BigDecimal(0)){
            breakevenPointCustomDTO.setUnitProduction( multiply.divide(breakevenPointCustomDTO.getIndustrialProfitCY(), 3, RoundingMode.HALF_UP));
        }
        if(!breakevenPointCustomDTO.getFixedAssets().multiply(breakevenPointCustomDTO.getYearlySalesCY()).equals(0)){
            breakevenPointCustomDTO.setResult6( breakevenPointCustomDTO.getFixedAssets().multiply(breakevenPointCustomDTO.getYearlySalesCY()).divide(breakevenPointCustomDTO.getIndustrialProfitCY(),2, RoundingMode.HALF_UP));
        }
        return breakevenPointCustomDTO;
    }




}
