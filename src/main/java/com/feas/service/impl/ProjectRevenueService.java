package com.feas.service.impl;

import com.feas.domain.entity.EstimatedYearlySales;
import com.feas.domain.entity.ProjectRevenue;
import com.feas.domain.entity.ProjectRevenuePK;
import com.feas.domain.entity.dto.ProjectRevenueCustom;
import com.feas.domain.entity.dto.ProjectRevenueCustomDTO;
import com.feas.domain.entity.dto.ProjectRevenueDTO;
import com.feas.persistence.repository.ProjectRevenueRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Service
public class ProjectRevenueService {
    private final ProjectRevenueRepository projectRevenueRepository;
    private static final MathContext math=new MathContext(3, RoundingMode.HALF_UP);

    public ProjectRevenueService(ProjectRevenueRepository projectRevenueRepository) {
        this.projectRevenueRepository = projectRevenueRepository;
    }

    public int updateYrlySalesValCyFromEstimatedYearlySales(long requestNumberIf,BigDecimal yrlySalesValCy){
        return projectRevenueRepository.updateYrlySalesValCyFromEstimatedYearlySales(requestNumberIf, yrlySalesValCy);
    }
    public ProjectRevenueCustomDTO getProjectRevenueCustom(long requestNumberIf,long licenseNumberIf) {
        ProjectRevenueCustomDTO revenueCustom=null;
        List<ProjectRevenueCustom> projectRevenueCustom = projectRevenueRepository.getProjectRevenueCustom(requestNumberIf, licenseNumberIf);
        if(projectRevenueCustom!=null){

            ProjectRevenueCustom reve= projectRevenueCustom.get(0);
            revenueCustom=new ProjectRevenueCustomDTO(reve.getProjectnumberif(),
                    reve.getRequestnumberif(),
                    reve.getYrlysalesvalcy(),
                    reve.getYrlyprodexpcy(),
                    reve.getPercprodlosscy(),
                    reve.getProductionlossnr(),
                    reve.getProjectrevenue(),
                    reve.getUsername(),
                    reve.getOperation(),
                    reve.getDatestamp(),
                    reve.getLicensenumberif(),
                    reve.getSumyrlyprodexpcy(),
                    reve.getSumyearlysalesvaluecy(),
                    reve.getPercprodlosscy(),
                    reve.getFixedassetcostequipment(),
                    reve.getYearlyfixedexpense(),
                    reve.getYearlydepreciation(),
                    reve.getYearlyvariableexpense1(),
                    reve.getYearlyvariableexpense2(),
                    reve.getYearlyvariableexpense3(),
                    reve.getYearlyvariableexpense4(),
                    reve.getYearlyvariableexpense5(),
                    null,
                    null,
                    null);
            BigDecimal total = getTotal(reve);
            revenueCustom.setTotal(total);
            revenueCustom.setSumyrlyprodexpcy(total);
            revenueCustom.setPerProductionExpense(getPerProductionExpense(revenueCustom));
            revenueCustom.setSumYearlyProdExpense(getSumYearlyProdExpense(revenueCustom));

            return revenueCustom;
        }
        return revenueCustom;
    }
    public long update(ProjectRevenueDTO projectRevenueDTO) {
        ProjectRevenuePK projectRevenuePK=new ProjectRevenuePK();
        projectRevenuePK.setProjectNumberIf(projectRevenueDTO.getProjectNumberIf());
        projectRevenuePK.setLicenseNumberIf(projectRevenueDTO.getLicenseNumberIf());
        projectRevenuePK.setRequestNumberIf(projectRevenueDTO.getRequestNumberIf());
        Optional<ProjectRevenue> byId = projectRevenueRepository.findById(projectRevenuePK);
        if(byId.isPresent()){
            if(projectRevenueDTO.getYrlySalesValCy()!=null&&!projectRevenueDTO.getYrlySalesValCy().equals(0)){
                int l = updateYrlySalesValCyFromEstimatedYearlySales(projectRevenueDTO.getRequestNumberIf(), projectRevenueDTO.getYrlySalesValCy());
                System.out.println(l);
                return 1;
            }
        }else{
            //new projectRevenue
        }
        return 0;
    }

    public BigDecimal getYearlyOtherVariable(ProjectRevenueCustom reve) {
        BigDecimal V_A = reve.getYearlyvariableexpense1();
        BigDecimal V_B = reve.getYearlyvariableexpense2();
        BigDecimal V_C = reve.getYearlyvariableexpense3();
        BigDecimal V_D = reve.getYearlyvariableexpense4();
        BigDecimal V_E = reve.getYearlyvariableexpense5();
        BigDecimal v1 = (V_C.multiply(V_B)).divide(new BigDecimal(100));
        BigDecimal v2 = (V_D.multiply(V_E)).divide(new BigDecimal(100));

        BigDecimal V_TOT = V_A.add(v1).add(v2);
        return V_TOT;
    }

    public BigDecimal getTotal(ProjectRevenueCustom reve) {
        BigDecimal tot=(BigDecimal) (reve.getYearlyfixedexpense().equals(null)?new BigDecimal(0):reve.getYearlyfixedexpense())
                                          .add(reve.getYearlydepreciation().equals(null)?new BigDecimal(0):reve.getYearlydepreciation())
                                             .add(getYearlyOtherVariable(reve));
        return tot;

    }

    public BigDecimal getPerProductionExpense(ProjectRevenueCustomDTO reve) {
        return (BigDecimal) (reve.getTotal().equals(null)?new BigDecimal(0):reve.getTotal())
                .multiply(reve.getPercprodlosscy().equals(null)?new BigDecimal(0):reve.getPercprodlosscy())
                .divide(new BigDecimal(100));
    }
    public BigDecimal getSumYearlyProdExpense(ProjectRevenueCustomDTO reve) {
        BigDecimal sumYearlyProdExpense=new BigDecimal(0);
        sumYearlyProdExpense=(BigDecimal) (reve.getYrlysalesvalcy().equals(null)?new BigDecimal(0):reve.getYrlysalesvalcy())
                                                    .subtract((reve.getTotal().equals(null)?new BigDecimal(0):reve.getTotal())
                                                     .add(reve.getPerProductionExpense().equals(null)?new BigDecimal(0):reve.getPerProductionExpense()));
        return sumYearlyProdExpense;
    }
}
