package com.feas.service.impl;

import com.feas.domain.config.CheckUtils;
import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.ValAddedNi;
import com.feas.domain.entity.YearlyFixedExpens;
import com.feas.domain.entity.dto.ValAddedNiReadOnlyFields;
import com.feas.domain.entity.dto.ValAddedNiReadOnlyFieldsDTO;
import com.feas.domain.entity.dto.ValAddedNiResponse;
import com.feas.persistence.repository.ValAddedNiRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Service
public class ValAddedNiService {

    private final ValAddedNiRepository valAddedNiRepository;
    private final EconomicalStudySummaryService economicalStudySummaryService;

    public ValAddedNiService(ValAddedNiRepository valAddedNiRepository, EconomicalStudySummaryService economicalStudySummaryService) {
        this.valAddedNiRepository = valAddedNiRepository;
        this.economicalStudySummaryService = economicalStudySummaryService;
    }

    public ValAddedNiReadOnlyFields getAllValAddedNiReadOnlyFields(BigDecimal requestNumber, BigDecimal licenseNumber){
        ValAddedNiReadOnlyFields allValAddedNiReadOnlyFields = valAddedNiRepository.getAllValAddedNiReadOnlyFields(requestNumber, licenseNumber);
        ValAddedNiReadOnlyFieldsDTO valAddedNiReadOnlyFieldsDTO = fromInterfaceToClass(allValAddedNiReadOnlyFields);
       BigDecimal total= (valAddedNiReadOnlyFieldsDTO.getProjectCharge()==null?new BigDecimal(0):valAddedNiReadOnlyFieldsDTO.getProjectCharge())
                .add(valAddedNiReadOnlyFieldsDTO.getWorkerRemuneration()==null?new BigDecimal(0):valAddedNiReadOnlyFieldsDTO.getWorkerRemuneration())
                .add(valAddedNiReadOnlyFieldsDTO.getAuditingAccounts()==null?new BigDecimal(0):valAddedNiReadOnlyFieldsDTO.getAuditingAccounts())
                        .add(valAddedNiReadOnlyFieldsDTO.getBuildingTools()==null?new BigDecimal(0):valAddedNiReadOnlyFieldsDTO.getBuildingTools())
                                .add(valAddedNiReadOnlyFieldsDTO.getAdvertExpCy()==null?new BigDecimal(0):valAddedNiReadOnlyFieldsDTO.getAdvertExpCy())
                                        .add(valAddedNiReadOnlyFieldsDTO.getVehInsurcy()==null?new BigDecimal(0):valAddedNiReadOnlyFieldsDTO.getVehInsurcy())
                                                .add(valAddedNiReadOnlyFieldsDTO.getRemigrations()==null?new BigDecimal(0):valAddedNiReadOnlyFieldsDTO.getRemigrations());
        valAddedNiReadOnlyFieldsDTO.setTotalValueAddedNi(total);

        ValAddedNiResponse valAddedNiByRequestAndLicence = valAddedNiRepository.getValAddedNiByRequestAndLicence(requestNumber, licenseNumber);
        if(valAddedNiByRequestAndLicence!=null){
            valAddedNiReadOnlyFieldsDTO.setRoyalties(valAddedNiByRequestAndLicence.getRoyalties());
            valAddedNiReadOnlyFieldsDTO.setSumProjectProfit(valAddedNiByRequestAndLicence.getSumprojectprofit());
            //valAddedNiReadOnlyFieldsDTO.setWorkerRemuneration(valAddedNiByRequestAndLicence.getWorkerRemuneration());
            valAddedNiReadOnlyFieldsDTO.setAuditingAccounts(valAddedNiByRequestAndLicence.getAuditingAccounts());
            valAddedNiReadOnlyFieldsDTO.setAdvertExpCy(valAddedNiByRequestAndLicence.getPublicityAdv());
            valAddedNiReadOnlyFieldsDTO.setVehInsurcy(allValAddedNiReadOnlyFields.getVehInsurcy());
            valAddedNiReadOnlyFieldsDTO.setRemigrations(valAddedNiByRequestAndLicence.getRemigrations());
            valAddedNiReadOnlyFieldsDTO.setPublicityAdv(valAddedNiByRequestAndLicence.getPublicityAdv());
            valAddedNiReadOnlyFieldsDTO.setRequestNumberIf(requestNumber);
            valAddedNiReadOnlyFieldsDTO.setLicenseNumberIf(licenseNumber);
            valAddedNiReadOnlyFieldsDTO.setAdvertExpCy(CheckUtils.isNullOrZero (valAddedNiRepository.calAdvertExpCytQuery(requestNumber))?new BigDecimal(0):valAddedNiRepository.calAdvertExpCytQuery(requestNumber));
            valAddedNiReadOnlyFieldsDTO.setAuditingAccounts(CheckUtils.isNullOrZero(valAddedNiRepository.calAuditExpCy(requestNumber))?new BigDecimal(0):valAddedNiRepository.calAuditExpCy(requestNumber));

        }
        return valAddedNiReadOnlyFieldsDTO;
    }


    //convert from interface to class after projection to calculate field
 private ValAddedNiReadOnlyFieldsDTO  fromInterfaceToClass(ValAddedNiReadOnlyFields valAddedNiReadOnlyFields){
     ValAddedNiReadOnlyFieldsDTO valAddedNiReadOnlyFieldsDTO=new ValAddedNiReadOnlyFieldsDTO();
        if(valAddedNiReadOnlyFields!=null){
            valAddedNiReadOnlyFieldsDTO.setAdvertExpCy(valAddedNiReadOnlyFields.getAdvertExpCy());
            valAddedNiReadOnlyFieldsDTO.setBuildingTools(valAddedNiReadOnlyFields.getBuildingTools());
            valAddedNiReadOnlyFieldsDTO.setRemigrations(valAddedNiReadOnlyFields.getRemigrations());
            valAddedNiReadOnlyFieldsDTO.setRoyalties(valAddedNiReadOnlyFields.getRoyalties());
            valAddedNiReadOnlyFieldsDTO.setTotalValueAddedNi(valAddedNiReadOnlyFields.getTotalValueAddedNi());
            valAddedNiReadOnlyFieldsDTO.setAuditingAccounts(valAddedNiReadOnlyFields.getAuditingAccounts());
            valAddedNiReadOnlyFieldsDTO.setInterestOnloan(valAddedNiReadOnlyFields.getInterestOnloan());
            valAddedNiReadOnlyFieldsDTO.setProjectCharge(valAddedNiReadOnlyFields.getProjectCharge());
            valAddedNiReadOnlyFieldsDTO.setVehInsurcy(valAddedNiReadOnlyFields.getVehInsurcy());
            valAddedNiReadOnlyFieldsDTO.setProjectRevenue(valAddedNiReadOnlyFields.getProjectRevenue());
            valAddedNiReadOnlyFieldsDTO.setWorkerRemuneration(valAddedNiReadOnlyFields.getWorkerRemuneration());
            valAddedNiReadOnlyFieldsDTO.setYearlyFixedExpenses(valAddedNiReadOnlyFields.getYearlyFixedExpenses());
        }
      return valAddedNiReadOnlyFieldsDTO;
    }

    public ValAddedNi save(ValAddedNiReadOnlyFields valAddedNiReadOnlyFields) {

        Optional<ValAddedNi> valAddedNiByRequestNumberIfAndLicenseNumberIf = valAddedNiRepository.findValAddedNiByRequestNumberIfAndLicenseNumberIf(valAddedNiReadOnlyFields.getRequestNumberIf(), valAddedNiReadOnlyFields.getLicenseNumberIf());
        ValAddedNi valAddedNi=null;
       if(valAddedNiByRequestNumberIfAndLicenseNumberIf.isPresent()){
            valAddedNi = valAddedNiByRequestNumberIfAndLicenseNumberIf.get();
           valAddedNi.setProjectCharges(valAddedNiReadOnlyFields.getProjectCharge());
           valAddedNi.setWorkerRemuneration(valAddedNiReadOnlyFields.getWorkerRemuneration());
           valAddedNi.setBuildingTools(valAddedNiReadOnlyFields.getBuildingTools());
           valAddedNi.setVehInsurCy(valAddedNiReadOnlyFields.getVehInsurcy());
           valAddedNi.setPublicityAdv(valAddedNiReadOnlyFields.getPublicityAdv());
           valAddedNi.setAuditingAccounts(valAddedNiReadOnlyFields.getAuditingAccounts());
           valAddedNi.setInterestOnLoan(valAddedNiReadOnlyFields.getInterestOnloan());
           valAddedNi.setRoyalties(valAddedNiReadOnlyFields.getRoyalties());
           valAddedNi.setRemigrations(valAddedNiReadOnlyFields.getRemigrations());
       }
        EconomicalStudySummary economicalStudySummaryOrCreateNew = economicalStudySummaryService.getEconomicalStudySummaryOrCreateNew(valAddedNiReadOnlyFields.getRequestNumberIf().longValue(), valAddedNiReadOnlyFields.getLicenseNumberIf().longValue());
        economicalStudySummaryOrCreateNew.setTotalValAddNatIncmCy(valAddedNiReadOnlyFields.getTotalValueAddedNi());
        economicalStudySummaryService.save(economicalStudySummaryOrCreateNew);

        return valAddedNiRepository.save(valAddedNi);
    }
}
