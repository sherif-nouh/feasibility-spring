package com.feas.api.controller;

import com.feas.domain.entity.RawMaterialStorage;
import com.feas.domain.entity.dto.RawMaterialStorageDTO;
import com.feas.domain.entity.dto.RemarksTechDTO;
import com.feas.domain.entity.lookups.RemarksTech;
import com.feas.service.impl.RemarksTechService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٦/٢٠٢٣
 */
@RestController()
@RequestMapping("/remarks-tech")
@Tag(name = "remarks-tech", description = "N_TECHNICAL_ONE -   وصف مختصر للعملية الإنتاجية")
public class RemarksTechController {
    private final RemarksTechService remarksTechService;

    public RemarksTechController(RemarksTechService remarksTechService) {
        this.remarksTechService = remarksTechService;
    }

    @GetMapping
    public BaseResponse<RemarksTech> getRemarksTech(@RequestParam(defaultValue = "-1") Long licenseNumberIf,
                                                    @RequestParam(defaultValue = "-1") Long requestNumberIf){
        return new BaseResponse<>(remarksTechService.getRemarksTech(licenseNumberIf,requestNumberIf), HttpStatus.OK.toString());
    }
    @PostMapping
    public BaseResponse<RemarksTech> addRemarksTech(@RequestBody RemarksTechDTO remarksTech) throws URISyntaxException {
        remarksTech.setOperation("I");
        RemarksTech addRemarksTech1 = remarksTechService.addRemarksTech(remarksTech);
        if(addRemarksTech1!=null){
            return new BaseResponse(addRemarksTech1,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
    @PutMapping
    public BaseResponse<RemarksTech> updateRemarksTech(@RequestBody RemarksTechDTO remarksTech) throws URISyntaxException {
        remarksTech.setOperation("U");
        if(remarksTech!=null && "D".equalsIgnoreCase(remarksTech.getOperation()) ){
            remarksTech.setOperation("D");
        }else{
            remarksTech.setOperation("U");
        }
        RemarksTech addRemarksTech1 = remarksTechService.addRemarksTech(remarksTech);
        if(addRemarksTech1!=null){
            return new BaseResponse(addRemarksTech1,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteRemarksTech(@RequestBody RemarksTech remarksTech) throws URISyntaxException {
        remarksTech.setInsertDt(new Date());
        remarksTech.setOperation("D");
        RemarksTech addRemarksTech1 = remarksTechService.deleteRemarksTech(remarksTech);

        if(addRemarksTech1!=null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
