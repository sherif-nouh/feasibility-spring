package com.feas.service.impl;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.EconomicalStudySummaryPK;
import com.feas.domain.entity.dto.IndustrialProfitROVO;
import com.feas.domain.entity.dto.IndustrialProfitROVODTO;
import com.feas.domain.entity.dto.YearlyFixedVariableExpenseDTO;
import com.feas.persistence.repository.EconomicalStudySummaryRepository;
import com.feas.persistence.repository.YearlyDepreciationRepository;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٨/٢٠٢٣
 */
@Service
public class IndustrialProfitROVOService {

    private final YearlyDepreciationRepository yearlyDepreciationRepository;
    private final EconomicalStudySummaryRepository economicalStudySummaryRepository;

    public IndustrialProfitROVOService(YearlyDepreciationRepository yearlyDepreciationRepository, EconomicalStudySummaryRepository economicalStudySummaryRepository) {
        this.yearlyDepreciationRepository = yearlyDepreciationRepository;
        this.economicalStudySummaryRepository = economicalStudySummaryRepository;
    }

    public IndustrialProfitROVODTO getIndustrialProfitROVO(long requestNumberId, long licenseNumberId) {
        IndustrialProfitROVO industrialProfitROVO = yearlyDepreciationRepository.getIndustrialProfitROVO(requestNumberId, licenseNumberId);
        EconomicalStudySummaryPK economicalStudySummaryPK = new EconomicalStudySummaryPK();
        economicalStudySummaryPK.setRequestNumberIf(requestNumberId);
        economicalStudySummaryPK.setProjectNumberIf(licenseNumberId);
        economicalStudySummaryPK.setLicenseNumberIf(licenseNumberId);
        Optional<EconomicalStudySummary> byId = economicalStudySummaryRepository.findById(economicalStudySummaryPK);
        IndustrialProfitROVODTO industrialProfitROVODTO = IndustrialProfitROVODTO
                .builder()
                .annualSales(industrialProfitROVO.getAnnualSales())
                .tyrDepCy(industrialProfitROVO.getTyrDepCy().setScale(3, RoundingMode.HALF_UP))
                .totalValAddNatIncmCy(industrialProfitROVO.getTotalValAddNatIncmCy())
                .licenseNumberId(industrialProfitROVO.getLicenseNumberId())
                .requestNumberId(industrialProfitROVO.getRequestNumberId())
                .yearlyDepreciation(byId.isPresent() ? byId.get().getTYrVarExpCy() : new BigDecimal(0))
                .build();
        // industrialProfitROVODTO.setAnnualSales(CheckUtils.isNullOrZero(industrialProfitROVODTO.getAnnualSales())?new BigDecimal(0):industrialProfitROVODTO.getAnnualSales());
        // industrialProfitROVODTO.setYearlyDepreciation(CheckUtils.isNullOrZero(industrialProfitROVODTO.getYearlyDepreciation())?new BigDecimal(0):industrialProfitROVODTO.getYearlyDepreciation());
        // industrialProfitROVODTO.setTYrDepCy(CheckUtils.isNullOrZero(industrialProfitROVODTO.getTYrDepCy())?new BigDecimal(0):industrialProfitROVODTO.getTYrDepCy());
        // industrialProfitROVODTO.setTotalValAddNatIncmCy(CheckUtils.isNullOrZero(industrialProfitROVODTO.getTotalGrossValueAdded())?new BigDecimal(0):industrialProfitROVODTO.getTotalValAddNatIncmCy());

        industrialProfitROVODTO.setSumIndustrialProfit(industrialProfitROVODTO.getAnnualSales().add(industrialProfitROVO.getYearlyDepreciation()));
        industrialProfitROVODTO.setTotalGrossValueAdded(industrialProfitROVODTO.getTotalValAddNatIncmCy().add(industrialProfitROVODTO.getTyrDepCy()));
        return industrialProfitROVODTO;
    }

    public EconomicalStudySummary saveEconomicStudy(IndustrialProfitROVODTO industrialProfitROVODTO) {
        EconomicalStudySummaryPK economicalStudySummaryPK = new EconomicalStudySummaryPK();
        economicalStudySummaryPK.setRequestNumberIf(industrialProfitROVODTO.getRequestNumberId());
        economicalStudySummaryPK.setProjectNumberIf(industrialProfitROVODTO.getLicenseNumberId());
        economicalStudySummaryPK.setLicenseNumberIf(industrialProfitROVODTO.getLicenseNumberId());
        Optional<EconomicalStudySummary> byId = economicalStudySummaryRepository.findById(economicalStudySummaryPK);
        EconomicalStudySummary save = null;
        if (byId.isPresent()) {
            EconomicalStudySummary economicalStudySummary = byId.get();
            economicalStudySummary.setTYrVarExpCy(industrialProfitROVODTO.getYearlyDepreciation());
            save = economicalStudySummaryRepository.save(economicalStudySummary);
        }
        if (save != null) {
            return save;

        } else {
            return null;
        }

    }
}
