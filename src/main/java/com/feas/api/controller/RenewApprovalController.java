package com.feas.api.controller;


import com.feas.domain.entity.*;
import com.feas.domain.entity.dto.EstimatedYearlySaleDTO;
import com.feas.domain.entity.dto.ValAddedNiReadOnlyFields;
import com.feas.persistence.repository.FeasibilityPendingViewRepository;
import com.feas.service.impl.FinishedGoodsStorageService;
import com.feas.service.impl.LicenseProductionService;
import com.feas.service.impl.RenewApprovalService;
import com.feas.service.impl.UpdateFeasRemarksService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/renewApproval")
@Tag(name = "N_RENEW_APPROVAL", description = "تحديث موافقة")
public class RenewApprovalController {


    @Autowired
    private RenewApprovalService renewApprovalSrv;
    @Autowired
    private FinishedGoodsStorageService finGoodsStoreSrv;
    @Autowired
    private UpdateFeasRemarksService updateFeasRemarksSrv;
    @Autowired
    private LicenseProductionService licProdSrv;


    @GetMapping("/renewGetAllData")
    @ResponseBody
    public BaseResponse<Object> renewGetAllData(@RequestParam(name = "reqId") long requestNumberId, @RequestParam(name = "licNo") String licenseNumber){
        List<FinishedGoodsStorage> goods = finGoodsStoreSrv.getAllFinishedGoodsStorageByReqIdAndLicNo(new BigDecimal(requestNumberId),new BigDecimal(licenseNumber));
        List<FeasibilityPendingVw> feasPend = renewApprovalSrv.selectFeasibilityPendingVwByReqAndLic(requestNumberId, licenseNumber);
        List<UpdateFeasRemarks> feasRemarks = updateFeasRemarksSrv.getByReqIdAndLicNo(requestNumberId,Long.getLong(licenseNumber));
        List<LicenseProduction> licProd = licProdSrv.findByLicenseNumberIf(Long.getLong(licenseNumber));
        return null;
    }

    @GetMapping("/getAllFinGoodsByReqAndLic")
    @ResponseBody
    public BaseResponse<List<FinishedGoodsStorage>> getAllFinGoodsByReqAndLic(@RequestParam(name = "reqId") long requestNumberId, @RequestParam(name = "licNo") String licenseNumber){
        List<FinishedGoodsStorage> goods = finGoodsStoreSrv.getAllFinishedGoodsStorageByReqIdAndLicNo(new BigDecimal(requestNumberId),new BigDecimal(licenseNumber));
        return new BaseResponse<>(goods, HttpStatus.OK.toString());
    }

    @GetMapping("/getFeasPendingByReqAndLic")
    @ResponseBody
    public BaseResponse<List<FeasibilityPendingVw>> getFeasPendingByReqAndLic(@RequestParam(name = "reqId") Long requestNumberId,@RequestParam(name = "licNo") String licNo){
        List<FeasibilityPendingVw> rslt = renewApprovalSrv.selectFeasibilityPendingVwByReqAndLic(requestNumberId, licNo);
        return new BaseResponse<>(rslt, HttpStatus.OK.toString());
    }


    @PostMapping("/saveRemarks")
    public BaseResponse<UpdateFeasRemarks> addUpdateRemarks(@RequestBody UpdateFeasRemarks updateFeasRemarks) throws URISyntaxException {

        UpdateFeasRemarks save = updateFeasRemarksSrv.save(updateFeasRemarks);
        return new BaseResponse<>(save, HttpStatus.OK.toString());
//        if(save!=null){
//            return new BaseResponse<>(save,HttpStatus.CREATED.toString());
//        }else{
//            return new BaseResponse<>(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
//        }
//

    }
    @GetMapping("/listFeasRemarksByReqIdAndLicNo")
        public List<UpdateFeasRemarks> listFeasRemarksByReqIdAndLicNo(@RequestParam(name = "reqId") Long reqId,@RequestParam(name = "licNo") Long licNo){
        return updateFeasRemarksSrv.getByReqIdAndLicNo(reqId,licNo);
    }

    @GetMapping("/getLicProdByLicNum")
        public List<LicenseProduction> getLicProdByLicNum(@RequestParam(name = "licNo")Long licenseNumberIf){
        return licProdSrv.findByLicenseNumberIf(licenseNumberIf);
    }
}
