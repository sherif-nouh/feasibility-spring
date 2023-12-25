package com.feas.api.controller;

import com.feas.domain.entity.FeasbilityRejection;
import com.feas.domain.entity.dto.FeasbilityRejectionDTO;
import com.feas.service.impl.FeasbilityRejectionService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ١٤/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/remarks-details")
@Tag(name = "N_REMARKS_DETAILS", description = "ملاحظات مركز الخدمة")
public class FeasbilityRejectionController {

    private final FeasbilityRejectionService feasbilityRejectionService;

    public FeasbilityRejectionController(FeasbilityRejectionService feasbilityRejectionService) {
        this.feasbilityRejectionService = feasbilityRejectionService;
    }

    @GetMapping
    public BaseResponse<FeasbilityRejection> getAllManPowerByRequestNumber(@RequestParam(defaultValue = "-1") long requestNumberIf){
        Optional<FeasbilityRejection> feasbilityRejection = feasbilityRejectionService.getById(requestNumberIf);
        if(feasbilityRejection.isPresent()) {
            return new BaseResponse<>(feasbilityRejection.get(), HttpStatus.OK.toString());
        }else{
            return new BaseResponse<>(null, HttpStatus.OK.toString());

        }
    }

    @PutMapping
    public BaseResponse<FeasbilityRejection> editProposedGeneralFacility(@RequestBody FeasbilityRejectionDTO feasbilityRejectionDTO) throws URISyntaxException {
        feasbilityRejectionDTO.setInsertDt(new Date());
        FeasbilityRejection feasbilityRejection = feasbilityRejectionService.updateFeasbilityRejection(feasbilityRejectionDTO);
        if(feasbilityRejection!=null){
            return new BaseResponse(feasbilityRejection,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

}
