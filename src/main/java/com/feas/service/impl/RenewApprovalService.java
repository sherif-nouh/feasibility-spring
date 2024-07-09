package com.feas.service.impl;

import com.feas.domain.entity.FeasibilityPendingVw;
import com.feas.persistence.repository.BreakevenPointRepository;
import com.feas.persistence.repository.FeasibilityPendingViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RenewApprovalService {

    @Autowired
    private FeasibilityPendingViewRepository feasPendingRepo;

    public List<FeasibilityPendingVw> selectFeasibilityPendingVwByReqAndLic(long requestNumberId, String licenseNumber){
        List<FeasibilityPendingVw> x = feasPendingRepo.findByRequestNumberIdAndLicenseNo(requestNumberId, licenseNumber);
        return x;
   }

}
