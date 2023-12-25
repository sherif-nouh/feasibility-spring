package com.feas.service.impl;

import com.feas.domain.entity.ProposedProjectEquipment;
import com.feas.domain.entity.TechnicalStudySummary;
import com.feas.domain.entity.TechnicalStudySummaryPK;
import com.feas.domain.entity.dto.ProposedStockSummary;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.persistence.repository.TechnicalStudySummaryRepository;
import com.feas.persistence.repository.TempRequestRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TechnicalStudySummaryService {

    private final TechnicalStudySummaryRepository technicalStudySummaryRepository;
    private final TempRequestRepository tempRequestRepository;

    public TechnicalStudySummaryService(TechnicalStudySummaryRepository technicalStudySummaryRepository, TempRequestRepository tempRequestRepository) {
        this.technicalStudySummaryRepository = technicalStudySummaryRepository;
        this.tempRequestRepository = tempRequestRepository;
    }

    public TechnicalStudySummary saveTechnicalStudySummaryFromProposedProject(ProposedProjectEquipment proposedProjectEquipment){

         TechnicalStudySummaryPK TechStudSum = new TechnicalStudySummaryPK();
        TechStudSum.setLicenseNumberIf(proposedProjectEquipment.getLicenseNumberIf());
        TechStudSum.setRequestNumberIf(proposedProjectEquipment.getRequestNumberIf());
        TechStudSum.setProjectNumberIf(proposedProjectEquipment.getProjectNumberIf());
        Optional<TechnicalStudySummary> byId = technicalStudySummaryRepository.findById(TechStudSum);
        if(byId.isPresent()){
             byId.get().setTExpEquipAfterInstalCy(proposedProjectEquipment.getGrandTotal());
            byId.get().setNotesTx(proposedProjectEquipment.getNotesTx());
            byId.get().setOperation("U");

             return technicalStudySummaryRepository.save(byId.get());
        }else {
            TechnicalStudySummary newTechnical=new TechnicalStudySummary();
            newTechnical.setLicenseNumberIf(proposedProjectEquipment.getLicenseNumberIf());
            newTechnical.setProjectNumberIf(proposedProjectEquipment.getRequestNumberIf());
            newTechnical.setRequestNumberIf(proposedProjectEquipment.getProjectNumberIf());
            newTechnical.setTExpEquipAfterInstalCy(proposedProjectEquipment.getGrandTotal());
            newTechnical.setOperation("I");
            newTechnical.setDateStamp(new Date());
            byId.get().setTExpEquipAfterInstalCy(proposedProjectEquipment.getGrandTotal());
            byId.get().setNotesTx(proposedProjectEquipment.getNotesTx());
            return technicalStudySummaryRepository.save(newTechnical);
        }
    }

    public Optional<TechnicalStudySummary> getTechnicalStudySummaryService(TechnicalStudySummaryPK technicalStudySummaryPK){
        return technicalStudySummaryRepository.findById(technicalStudySummaryPK);
    }

    public TechnicalStudySummary saveTechnicalStudySummaryFromProposedProject(ProposedStockSummary proposedStockSummary){
        Optional<TempRequest> byRequestNumberIdAndLicenseNumberIf=null;
        if(null!=proposedStockSummary) {
            if(null!=proposedStockSummary.getRequestNumberIf()&&null!=proposedStockSummary.getLicenseNumberIf()) {
                byRequestNumberIdAndLicenseNumberIf = tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf(proposedStockSummary.getRequestNumberIf(), proposedStockSummary.getLicenseNumberIf());
            }
        }
        TechnicalStudySummaryPK TechStudSum = new TechnicalStudySummaryPK();
        TechStudSum.setLicenseNumberIf(proposedStockSummary.getLicenseNumberIf());
        TechStudSum.setRequestNumberIf(proposedStockSummary.getRequestNumberIf());
        TechStudSum.setProjectNumberIf(proposedStockSummary.getLicenseNumberIf());
        Optional<TechnicalStudySummary> byId = technicalStudySummaryRepository.findById(TechStudSum);
        if(byId.isPresent()){
            byId.get().setTValMatProdCifCy(proposedStockSummary.getSumStock());
            byId.get().setOperation("U");
            if(byRequestNumberIdAndLicenseNumberIf.isPresent()){
                byRequestNumberIdAndLicenseNumberIf.get().setReqHandlerIf(proposedStockSummary.getReqHandlerIf().doubleValue());
                byRequestNumberIdAndLicenseNumberIf.get().setRemarksBydept(proposedStockSummary.getRemarksByDept());
                tempRequestRepository.save(byRequestNumberIdAndLicenseNumberIf.get());
            }
            return technicalStudySummaryRepository.save(byId.get());
        }else {
            TechnicalStudySummary newTechnical=new TechnicalStudySummary();
            newTechnical.setLicenseNumberIf(proposedStockSummary.getLicenseNumberIf());
            newTechnical.setProjectNumberIf(proposedStockSummary.getRequestNumberIf());
            newTechnical.setRequestNumberIf(proposedStockSummary.getLicenseNumberIf());
            newTechnical.setTValMatProdCifCy(proposedStockSummary.getSumStock());
            newTechnical.setOperation("I");
            newTechnical.setDateStamp(new Date());
            if(byRequestNumberIdAndLicenseNumberIf.isPresent()){
                byRequestNumberIdAndLicenseNumberIf.get().setReqHandlerIf(proposedStockSummary.getReqHandlerIf().doubleValue());
                byRequestNumberIdAndLicenseNumberIf.get().setRemarksBydept(proposedStockSummary.getRemarksByDept());
                tempRequestRepository.save(byRequestNumberIdAndLicenseNumberIf.get());

            }
            return technicalStudySummaryRepository.save(newTechnical);
        }
    }
}
