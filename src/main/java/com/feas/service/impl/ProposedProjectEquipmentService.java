package com.feas.service.impl;

import com.feas.domain.entity.ProposedProjectEquipment;
import com.feas.domain.entity.TechnicalStudySummary;
import com.feas.domain.entity.TechnicalStudySummaryPK;
import com.feas.domain.entity.dto.ProposedProjectTempRequest;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.persistence.repository.ProposedProjectEquipmentRepository;
import com.feas.persistence.repository.TempRequestRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ProposedProjectEquipmentService {

    private final ProposedProjectEquipmentRepository projectEquipmentRepository;
    private final TempRequestRepository tempRequestRepository;
    private final TechnicalStudySummaryService technicalStudySummaryService;

    public ProposedProjectEquipmentService(ProposedProjectEquipmentRepository projectEquipmentRepository, TempRequestRepository tempRequestRepository, TechnicalStudySummaryService technicalStudySummaryService) {
        this.projectEquipmentRepository = projectEquipmentRepository;
        this.tempRequestRepository = tempRequestRepository;
        this.technicalStudySummaryService = technicalStudySummaryService;
    }


    public Optional<ProposedProjectEquipment> findById(Long id) {
        return  projectEquipmentRepository.findById(id);
    }

    public List<ProposedProjectEquipment> QueryAll(Long licenseNumberIf, Long requestNumberIf) {
        List<ProposedProjectEquipment> proposedProjectEquipments = projectEquipmentRepository.QueryAll(licenseNumberIf, requestNumberIf);
        long start1 = System.nanoTime();
        TechnicalStudySummary technicalStudySummary = getTechnicalStudySummary(licenseNumberIf, requestNumberIf);
        this.getTotalValue(proposedProjectEquipments).forEach(proposedProjectEquipment -> proposedProjectEquipment.setNotesTx(technicalStudySummary.getNotesTx()));
        proposedProjectEquipments=this.getAllSummeryFields(proposedProjectEquipments,licenseNumberIf, requestNumberIf);

        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));

        return proposedProjectEquipments;
    }


    public ProposedProjectEquipment save(ProposedProjectEquipment proposedProjectEquipment) {

        return projectEquipmentRepository.save(proposedProjectEquipment);
    }

    private TechnicalStudySummary getTechnicalStudySummary(Long licenseNumberIf, Long requestNumberIf){
        TechnicalStudySummaryPK technicalStudySummaryPK=new TechnicalStudySummaryPK();
        technicalStudySummaryPK.setProjectNumberIf(licenseNumberIf);
        technicalStudySummaryPK.setRequestNumberIf(requestNumberIf);
        technicalStudySummaryPK.setLicenseNumberIf(licenseNumberIf);
        Optional<TechnicalStudySummary> technicalStudySummaryService1 = technicalStudySummaryService.getTechnicalStudySummaryService(technicalStudySummaryPK);
        if(technicalStudySummaryService1.isPresent()){
            return technicalStudySummaryService1.get();
        }
        return new TechnicalStudySummary();
    }

    public List<ProposedProjectEquipment> getAllSummeryFields(List<ProposedProjectEquipment> proposedProjectEquipment,long licenseNumberIf,long requestNumberIf){
        MathContext mathContext=new MathContext(3);
        BigDecimal localEquip = projectEquipmentRepository.getLocalEquip(requestNumberIf);
        proposedProjectEquipment.forEach(prop ->{
            prop.setLocalEquip(localEquip);
            prop.setTotalInstall( this.getTotInstall(prop));
            prop.setTotalTransportation(this.getTotTransportation(prop));
            prop.setCif(this.getCif(prop));
            prop.setTotalFis(this.getTotalFis(prop));
            prop.setGrandTotal(this.getGranTotalFromLoc(prop));
        });

        return proposedProjectEquipment;
    }

    public List<ProposedProjectEquipment> getTotalValue(List<ProposedProjectEquipment> proposedProjectEquipment) {
           BigDecimal totalFob=new BigDecimal(0);
        for(ProposedProjectEquipment propObj:proposedProjectEquipment) {

            BigDecimal totalVal = new BigDecimal(0);


            BigDecimal exchangewith1 = propObj.getExchangeRateCy() == null ? new BigDecimal(1) : propObj.getExchangeRateCy();
            BigDecimal exchangewith0 = propObj.getExchangeRateCy() == null ? new BigDecimal(0) : propObj.getExchangeRateCy();
            BigDecimal forign = propObj.getUnitPriceCy() == null ? new BigDecimal(0) : propObj.getUnitPriceCy();

            long manufCtryCod = propObj.getManufCtryCodeIf() == null ? 0 : propObj.getManufCtryCodeIf();
            Long u1 = propObj.getQuantityNr() == null ? 0 : propObj.getQuantityNr().longValue();
            BigDecimal quantity = u1 == null ? new BigDecimal(0) : new BigDecimal(u1);
            BigDecimal serial = propObj.getSerialNumberId() == null ? new BigDecimal(0) : new BigDecimal(propObj.getSerialNumberId());
            int compareVal = propObj.getEquipPercIf() == null ? 0 : propObj.getEquipPercIf().intValue();
            BigDecimal locEquip = new BigDecimal(0);

            if ((manufCtryCod == 1 || manufCtryCod == 115 || manufCtryCod == 225) && exchangewith1.intValue() == 1) {
                locEquip = forign.multiply(exchangewith0).multiply(quantity);
            }
            if (compareVal == 4 && exchangewith1.intValue() == 1) {
                locEquip = forign.multiply(exchangewith0).multiply(quantity);
            }

            if ((manufCtryCod == 1 || manufCtryCod == 115 || manufCtryCod == 225) && exchangewith1.intValue() != 1) {
                locEquip = forign.multiply(exchangewith0).multiply(quantity);
            }

            if (compareVal == 1) {
                BigDecimal x = forign.multiply(exchangewith0).multiply(quantity);
                if (x.intValue() > 0) {
                    totalVal = x.divide(serial.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).add(new BigDecimal(1)), 2, RoundingMode.HALF_UP);
                }
                //cif=forign.multiply(exchangewith0).multiply(quantity);
            }
            if (compareVal == 2) {
                totalVal = ((forign.multiply(exchangewith0)).multiply(quantity));
            }
            if (compareVal == 3) {
                BigDecimal x = forign.multiply(exchangewith0).multiply(quantity);
                if (x.intValue() > 0) {
                    totalVal = x.multiply(serial.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).add(new BigDecimal(1))).divide(new BigDecimal(1.10), 2, RoundingMode.HALF_UP);
                }
            }
            if (compareVal == 4) {
                totalVal = new BigDecimal(0);
            }

            if (compareVal == 4 && exchangewith1.intValue() != 1) {
                totalVal = forign.multiply(exchangewith0).multiply(quantity);

            }

            propObj.setTotalValue(totalVal);
            totalFob=totalVal.add(totalFob);

        }
        BigDecimal finalTotalFob = totalFob;
        proposedProjectEquipment.forEach(f -> f.setTotalFob(finalTotalFob));

        return proposedProjectEquipment;
    }


    public BigDecimal getTotInstall(ProposedProjectEquipment propObj) {
        Optional<TempRequest> tempRequest = tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf(  propObj.getRequestNumberIf(),propObj.getLicenseNumberIf());
        TempRequest tempRequestData=new TempRequest();
        if(tempRequest.isPresent()){
            tempRequestData=tempRequest.get();
        }

        BigDecimal installEXP = new BigDecimal(0);
        if (tempRequestData != null) {
            installEXP = (BigDecimal) tempRequestData.getInstallExp();
        }
        BigDecimal totalFob = propObj.getTotalFob() == null ? new BigDecimal(0) : propObj.getTotalFob();
        installEXP = installEXP == null ? new BigDecimal(0) : installEXP;

        return totalFob.multiply(installEXP).divide(new BigDecimal(100));
    }

    public BigDecimal getTotTransportation(ProposedProjectEquipment propObj) {
        Optional<TempRequest> tempRequest = tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf(  propObj.getRequestNumberIf(),propObj.getLicenseNumberIf());
        TempRequest tempRequestData=new TempRequest();
                if(tempRequest.isPresent()){
                    tempRequestData=tempRequest.get();
                }

        BigDecimal Transp = new BigDecimal(0);
        if (tempRequestData != null) {
            Transp =  tempRequestData.getTranspExp();
        }
        BigDecimal totalFob = propObj.getTotalFob()== null ? new BigDecimal(0) : propObj.getTotalFob();
        Transp = Transp == null ? new BigDecimal(0) : Transp;
        return totalFob.multiply(Transp).divide(new BigDecimal(100));
    }

    public BigDecimal getCif(ProposedProjectEquipment propObj) {
        ProposedProjectTempRequest tempRequestData = tempRequestRepository.getTempRequestData( propObj.getLicenseNumberIf(), propObj.getRequestNumberIf());
        BigDecimal ContNo = new BigDecimal(0);
        if (tempRequestData != null){
            ContNo = tempRequestData.getContno();
            if(ContNo==null){
                ContNo = new BigDecimal(0);
            }
        }
        BigDecimal cont=new BigDecimal(0);
        if(ContNo.intValue()!=0){
            cont=ContNo.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);

        }
        return propObj.getTotalFob().multiply(cont.add(new BigDecimal(1) ));
    }

    public BigDecimal getGranTotalFromLoc(ProposedProjectEquipment propObj) {
        BigDecimal localEquip = projectEquipmentRepository.getLocalEquip(propObj.getRequestNumberIf());
        //BigDecimal localEquipD=new BigDecimal(localEquip);
        if (localEquip == null) {
            localEquip = new BigDecimal(0);
        }
        TempRequest tempRequestData = tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf( propObj.getLicenseNumberIf(), propObj.getRequestNumberIf()).orElse(null);
        BigDecimal InsuranceCy = new BigDecimal(0);
        if (tempRequestData != null) {
            InsuranceCy =  tempRequestData.getInsuranceCy();
        }
        /////////////////////////////
        BigDecimal TotInstall;
        BigDecimal Tottranspor;
        BigDecimal TotCif;
        TotInstall = propObj.getTotalInstall() == null ? new BigDecimal(0) : propObj.getTotalInstall();
        Tottranspor = propObj.getTotalTransportation() == null ? new BigDecimal(0) : propObj.getTotalTransportation();
        TotCif = propObj.getTotalFis() == null ? new BigDecimal(0) : propObj.getTotalFis();

        //localEquip = localEquip == null ? 0 : localEquip;
        InsuranceCy = InsuranceCy == null ? new BigDecimal(0) : InsuranceCy;
        return propObj.getTotalInstall().add(propObj.getTotalTransportation()).add(propObj.getCif()).add(localEquip).subtract(InsuranceCy);
    }


    public BigDecimal getTotalFis(ProposedProjectEquipment propObj) {
        TempRequest tempRequestData = tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf( propObj.getLicenseNumberIf(), propObj.getRequestNumberIf()).orElse(null);

        BigDecimal Cont = new BigDecimal(0);
        if (tempRequestData != null) {
            Cont = (BigDecimal) tempRequestData.getContractNo();
            if(Cont==null){
                Cont = new BigDecimal(0);
            }
        }
        BigDecimal totalFob = new BigDecimal(0);
        totalFob = propObj.getTotalFob() == null ? new BigDecimal(0) : propObj.getTotalFob() ;

        return totalFob.multiply(Cont).divide(new BigDecimal(100));
    }

}
