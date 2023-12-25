package com.feas.service.impl;

import com.feas.domain.config.CheckUtils;
import com.feas.domain.entity.dto.OperatingCapitalROV;
import com.feas.domain.entity.dto.OperatingCapitalROVDTO;
import com.feas.persistence.repository.OperatingCapitalRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Service
public class OperatingCapitalService {

    private final OperatingCapitalRepository operatingCapitalRepository;

    public OperatingCapitalService(OperatingCapitalRepository operatingCapitalRepository) {
        this.operatingCapitalRepository = operatingCapitalRepository;
    }

    public OperatingCapitalROVDTO getOperatingCapitalROV(BigDecimal requestNumberId){
        OperatingCapitalROV operatingCapitalRov = operatingCapitalRepository.getOperatingCapitalRov(requestNumberId);
        OperatingCapitalROVDTO operatingCapitalROVDTO=OperatingCapitalROVDTO
                .builder()
                .projectSetupCostCY(operatingCapitalRov.getProjectSetupCostCY())
                .operatingCapitalTotal(operatingCapitalRov.getOperatingCapitalTotal())
                .costOfStoRMat3MonthsCy(operatingCapitalRov.getCostOfStoRMat3MonthsCy())
                .costOfSals2MonthsCy(operatingCapitalRov.getCostOfSals2MonthsCy())
                .fixAssetCostCY(operatingCapitalRov.getFixAssetCostCY())
                .build();
        operatingCapitalROVDTO.setOperatingCapitalTotal( CheckUtils.isNullOrZero(operatingCapitalROVDTO.getOperatingCapitalTotal())?new BigDecimal(0):operatingCapitalROVDTO.getOperatingCapitalTotal());
        operatingCapitalROVDTO.setFixAssetCostCY(CheckUtils.isNullOrZero(operatingCapitalROVDTO.getFixAssetCostCY())?new BigDecimal(0):operatingCapitalROVDTO.getFixAssetCostCY());
        operatingCapitalROVDTO.setProjectSetupCostCY(CheckUtils.isNullOrZero(operatingCapitalROVDTO.getProjectSetupCostCY())?new BigDecimal(0):operatingCapitalROVDTO.getProjectSetupCostCY());

        operatingCapitalROVDTO.setTotalCapitalization(operatingCapitalROVDTO.getOperatingCapitalTotal().add(operatingCapitalROVDTO.getFixAssetCostCY()).add(operatingCapitalROVDTO.getProjectSetupCostCY()));
        return operatingCapitalROVDTO;
    }

    public Object updateOperationCapital(String requestNumber, OperatingCapitalROV operatingCapitalROV) {
 return null;
    }
}
