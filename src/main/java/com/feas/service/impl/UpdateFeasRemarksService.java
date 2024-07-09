package com.feas.service.impl;

import com.feas.domain.entity.UpdateFeasRemarks;
import com.feas.persistence.repository.UpdateFeasRemarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateFeasRemarksService {
    @Autowired
    UpdateFeasRemarksRepository updateFeasRemarksRepo;

    public UpdateFeasRemarks save(UpdateFeasRemarks ufr){
        return updateFeasRemarksRepo.save(ufr);
    }

    public List<UpdateFeasRemarks> getByReqIdAndLicNo(Long reqId, Long licNo){
        return updateFeasRemarksRepo.findByRequestNumberIfAndLicenseNumberIf(reqId,licNo);
    }
}
