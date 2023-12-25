package com.feas.service.impl;

import com.feas.domain.entity.ProjectFinancing;
import com.feas.domain.entity.dto.ProjectFinancingCalculation;
import com.feas.domain.entity.dto.ProjectFinancingDTO;
import com.feas.domain.entity.dto.ProjectFinancingResponse;
import com.feas.domain.entity.dto.ProjectFinancingResponseDTO;
import com.feas.persistence.repository.ProjectFinancingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Service
public class ProjectFinancingService {
    private final ProjectFinancingRepository  projectFinancingRepository;
    private final ModelMapper modelMapper;

    public ProjectFinancingService(ProjectFinancingRepository projectFinancingRepository, ModelMapper modelMapper) {
        this.projectFinancingRepository = projectFinancingRepository;
        this.modelMapper = modelMapper;
    }

    
    public ProjectFinancingResponseDTO fetchAllProjectFinancingByRequestNumberAndLicense(BigDecimal requestNumberIf, BigDecimal licenseNumberIf){
         ProjectFinancingResponse projectFinancingResponse = projectFinancingRepository.fetchAllProjectFinancingByRequestNumberAndLicense(requestNumberIf, licenseNumberIf);
        ProjectFinancingResponseDTO projectFinancingResponseDTO=ProjectFinancingResponseDTO
                .builder()
                .operatingcapitalvalue(projectFinancingResponse.getOperatingcapitalvalue())
                .creditfacicy(projectFinancingResponse.getCreditfacicy())
                .operation(projectFinancingResponse.getOperation())
                .licensenumberif(projectFinancingResponse.getLicensenumberif())
                .loanfromcommbankcy(projectFinancingResponse.getLoanfromcommbankcy())
                .loanfromindbankcy(projectFinancingResponse.getLoanfromindbankcy())
                .paidupcapcy(projectFinancingResponse.getPaidupcapcy())
                .percinterestloancombnr(projectFinancingResponse.getPercinterestloancombnr())
                .percinterestloanindbnr(projectFinancingResponse.getPercinterestloanindbnr())
                .requestnumberif(projectFinancingResponse.getRequestnumberif())
                .projectfinancingid(projectFinancingResponse.getProjectfinancingid())
                .projectnumberif(projectFinancingResponse.getProjectnumberif())
                .username(projectFinancingResponse.getUsername())
                .fixedassetcostvalue(projectFinancingResponse.getFixedassetcostvalue())
                .projectsetupcostvalue(projectFinancingResponse.getProjectsetupcostvalue())
                .build();

        projectFinancingResponseDTO.setTotalFinancing(projectFinancingResponseDTO.getOperatingcapitalvalue().add(projectFinancingResponseDTO.getProjectsetupcostvalue()).add(projectFinancingResponseDTO.getFixedassetcostvalue()));
        projectFinancingResponseDTO.setCommercialBank(projectFinancingResponseDTO.getLoanfromindbankcy().multiply(projectFinancingResponseDTO.getPercinterestloancombnr().divide(new BigDecimal(100),3, RoundingMode.HALF_EVEN)));
        projectFinancingResponseDTO.setIndustrialBank(projectFinancingResponseDTO.getLoanfromcommbankcy().multiply(projectFinancingResponseDTO.getPercinterestloanindbnr().divide(new BigDecimal(100),3,RoundingMode.HALF_EVEN)));
        projectFinancingResponseDTO.setInsertOnLoan(projectFinancingResponseDTO.getCommercialBank().add(projectFinancingResponseDTO.getIndustrialBank()));
        return projectFinancingResponseDTO;
    }

    public ProjectFinancing getAllProjectFinancingByRequestNumberAndLicense(BigDecimal requestNumberIf, BigDecimal licenseNumberIf) {
        List<ProjectFinancing> allProjectFinancingByRequestNumberAndLicense = projectFinancingRepository.getAllProjectFinancingByRequestNumberAndLicense(requestNumberIf, licenseNumberIf);
        ProjectFinancing projectFinancing=null;
        if(allProjectFinancingByRequestNumberAndLicense!=null){
            projectFinancing = allProjectFinancingByRequestNumberAndLicense.get(0);
        }
        ProjectFinancingCalculation projectFinancingCalculate = projectFinancingRepository.getProjectFinancingCalculate(requestNumberIf, licenseNumberIf);
        if(projectFinancingCalculate!=null){
            if(projectFinancing!=null){
                projectFinancing.setProjectSetupCostValue(projectFinancingCalculate.getProjectSetupCostValue());
                projectFinancing.setFixedAssetCostValue(projectFinancingCalculate.getFixedAssetCostValue());
                projectFinancing.setOperatingCapitalValue(projectFinancingCalculate.getOperatingCapitalValue());
                 //calculate total financing
                projectFinancing.setTotalFinancing((projectFinancingCalculate.getOperatingCapitalValue()==null?new BigDecimal(0):projectFinancingCalculate.getOperatingCapitalValue())
                        .add(projectFinancingCalculate.getFixedAssetCostValue()  ==null?new BigDecimal(0): projectFinancingCalculate.getFixedAssetCostValue())
                        .add(projectFinancingCalculate.getProjectSetupCostValue()==null?new BigDecimal(0):projectFinancingCalculate.getProjectSetupCostValue()));
                //calculate industrial bank
                projectFinancing.setIndustrialBank(projectFinancing.getLoanFromCommbankCy()
                        .multiply(projectFinancing.getPercInterestLoanIndbNr().divide(new BigDecimal(100))));

                projectFinancing.setCommercialBank(projectFinancing.getLoanFromIndbankCy()
                        .multiply(projectFinancing.getPercInterestLoanCombNr().divide(new BigDecimal(100))));
            }
        }
        return projectFinancing;
    }

    public Optional<ProjectFinancing> findById(Long id) {
        return projectFinancingRepository.findById(id);
    }

    public ProjectFinancing save(ProjectFinancingDTO projectFinancingDTO) {
        ProjectFinancing projectFinancing = modelMapper.map(projectFinancingDTO, ProjectFinancing.class);
        return projectFinancingRepository.save(projectFinancing);
    }

    public ProjectFinancingResponseDTO updateProjectFinancing(ProjectFinancingResponseDTO projectFinancingDTO) {
        Optional<ProjectFinancing> byId = projectFinancingRepository.findById(projectFinancingDTO.getProjectfinancingid());
        ProjectFinancing save=null;
        if(byId.isPresent()){
            ProjectFinancing projectFinancing = byId.get();
            projectFinancing.setPaidupCapCy(projectFinancingDTO.getPaidupcapcy());
            projectFinancing.setLoanFromIndbankCy(projectFinancingDTO.getLoanfromindbankcy());
            projectFinancing.setLoanFromCommbankCy(projectFinancingDTO.getLoanfromcommbankcy());
            projectFinancing.setCreditFaciCy(projectFinancingDTO.getCreditfacicy());
            projectFinancing.setPercInterestLoanIndbNr(projectFinancingDTO.getPercinterestloanindbnr());
            projectFinancing.setPercInterestLoanCombNr(projectFinancingDTO.getPercinterestloancombnr());
            projectFinancing.setOperation("U");
             save = projectFinancingRepository.save(projectFinancing);
        }
        if (save != null) {
            ProjectFinancingResponseDTO projectFinancing = modelMapper.map(save, ProjectFinancingResponseDTO.class);
            return projectFinancing;
        }
        return null;
        }
    }

