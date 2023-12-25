package com.feas.api.controller;

import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.dto.FinishedGoodsStorageDTO;
import com.feas.domain.entity.dto.FinishedGoodsStorageSummaryFields;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.service.impl.FinishedGoodsStorageService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠٩/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/finished-goods-storage")
@Tag(name = "finished-goods-storage", description = "N_FINISHED_GOOD_STORAGE -  المساحة اللازمة لتخزين المنتجات النهائية")
public class FinishedGoodsStorageController {
    private final FinishedGoodsStorageService finishedGoodsStorageService;

    public FinishedGoodsStorageController(FinishedGoodsStorageService finishedGoodsStorageService) {
        this.finishedGoodsStorageService = finishedGoodsStorageService;
    }

    @GetMapping
    public BaseResponse<List<FinishedGoodsStorage>> getAllManPowerByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<FinishedGoodsStorage> finishedGoodsStorage = finishedGoodsStorageService.getAllFinishedGoodsStorageByRequestNumber(requestNumberIf);
        return new BaseResponse<>(finishedGoodsStorage, HttpStatus.OK.toString());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BaseResponse<FinishedGoodsStorage> getOneById(@PathVariable Long id) throws Exception {
        Optional<FinishedGoodsStorage> finishedGoodsStorage= finishedGoodsStorageService.findById(id);
        return new BaseResponse<FinishedGoodsStorage>(finishedGoodsStorage.orElseThrow(() -> new Exception(" not found - " + id)),HttpStatus.OK.toString());
    }
    @GetMapping("/summary-fields")
    @ResponseBody
    public BaseResponse<FinishedGoodsStorageSummaryFields> getAllSummaryFields(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf) throws Exception {
        FinishedGoodsStorageSummaryFields finishedGoodsStorageSummaryFields= finishedGoodsStorageService.getAllSummeryFields(requestNumberIf);
        return new BaseResponse<FinishedGoodsStorageSummaryFields>(finishedGoodsStorageSummaryFields,HttpStatus.OK.toString());
    }
    @PostMapping
    @ResponseBody
    public BaseResponse addFinishedGoodsStorage(@RequestBody FinishedGoodsStorageDTO finishedGoodsStorageDTO)throws URISyntaxException {
        finishedGoodsStorageDTO.setDateStamp(new Date());

        FinishedGoodsStorage finishedGoodsStorage = finishedGoodsStorageService.save(finishedGoodsStorageDTO);
        if(finishedGoodsStorage!=null){
            return new BaseResponse(finishedGoodsStorage,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }

    }

    @PutMapping
    public BaseResponse<FinishedGoodsStorage> editProposedManpower(@RequestBody FinishedGoodsStorageDTO finishedGoodsStorageDTO) throws URISyntaxException {
        finishedGoodsStorageDTO.setDateStamp(new Date());
        if(finishedGoodsStorageDTO!=null && "D".equalsIgnoreCase(finishedGoodsStorageDTO.getOperation()) ){
            finishedGoodsStorageDTO.setOperation("D");
        }else{
            finishedGoodsStorageDTO.setOperation("U");
        }
        FinishedGoodsStorage goodsStorage = finishedGoodsStorageService.updateProposedManpower(finishedGoodsStorageDTO);
        if(goodsStorage!=null){
            return new BaseResponse(goodsStorage,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @PutMapping("/summary-fields")
    @ResponseBody
    public BaseResponse updateFinishGoodsStorageSummary(@RequestBody TempRequestDTO tempRequestDTO)throws URISyntaxException {
        TempRequest tempRequest = finishedGoodsStorageService.updateSummaryFields(tempRequestDTO);
        if(tempRequest!=null){
            return new BaseResponse(tempRequest,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
    @DeleteMapping
    public BaseResponse<String> deleteProposedManpower(@PathVariable Long finishedGoodsStorageId) throws URISyntaxException {
        String finishedGoodsStorage = finishedGoodsStorageService.deleteFinishedGoodsStorage(finishedGoodsStorageId);
        return new BaseResponse(finishedGoodsStorage,HttpStatus.OK.toString());
    }


}
