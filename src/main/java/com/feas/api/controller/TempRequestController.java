package com.feas.api.controller;

import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.ProposedProjectEquipment;
import com.feas.domain.entity.dto.ProposedManpowerDTO;
import com.feas.domain.entity.dto.ProposedProjectTempRequest;
import com.feas.domain.entity.dto.ProposedProjectTempRequestDTO;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.service.impl.TempRequestService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠٥/٠٧/٢٠٢٣
 */
@RestController
@RequestMapping("/temp-request")
@Tag(name = "temp-request", description = "temp-request - ")
public class TempRequestController {
    @Autowired
    private TempRequestService tempRequestService;

    @GetMapping
    @ResponseBody
    public BaseResponse<TempRequest> getTempRequestByLicAndReq(
            @RequestParam(defaultValue = "-1") Long requestNumberIf,
            @RequestParam(defaultValue = "-1") Long licenseNumberIf) {
        Optional<TempRequest> tempRequestByRequestNumberAndLicence = tempRequestService.getTempRequestByRequestNumberAndLicence( requestNumberIf,licenseNumberIf);
        return new BaseResponse<TempRequest>(tempRequestByRequestNumberAndLicence.orElse(new TempRequest()), HttpStatus.OK.toString());
    }

    @GetMapping("/summary-fields")
    @ResponseBody
    public BaseResponse<ProposedProjectTempRequest> getTempRequestSummaryByLicAndReq(
            @RequestParam(defaultValue = "-1") Long requestNumberIf,
            @RequestParam(defaultValue = "-1") Long licenseNumberIf) {
        ProposedProjectTempRequest tempRequestByRequestNumberAndLicence = tempRequestService.getProposedProjectTempRequest( licenseNumberIf,requestNumberIf);
        return new BaseResponse<ProposedProjectTempRequest>((tempRequestByRequestNumberAndLicence), HttpStatus.OK.toString());
    }


    @PutMapping
    public BaseResponse<TempRequest> editProposedManpower(@RequestBody TempRequestDTO tempRequest) throws URISyntaxException {
        if(tempRequest!=null && "D".equalsIgnoreCase(tempRequest.getOperation()) ){
            tempRequest.setOperation("D");
        }else{
            tempRequest.setOperation("U");
        }
        TempRequest tempRequest1 = tempRequestService.updateProposedManpower(tempRequest);
        if(tempRequest1!=null){
            return new BaseResponse(tempRequest1,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
