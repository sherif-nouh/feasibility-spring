package com.feas.api.controller;

import com.feas.domain.entity.Introduction;
import com.feas.domain.entity.ReportContent;
import com.feas.domain.entity.dto.ReportContentDTO;
import com.feas.persistence.repository.IntroductionRepository;
import com.feas.persistence.repository.ReportContentRepository;
import com.feas.service.impl.ReportContentService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ١٤/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/REPORT_CONTENT")
@Tag(name = "N_REPORT_CONTENT", description = "الفهرس")
public class ReportContentController {

    private final ReportContentService reportContentService;
    private final ReportContentRepository reportContentRepository;

    public ReportContentController(ReportContentService reportContentService, ReportContentRepository introductionRepository) {
        this.reportContentService = reportContentService;
        this.reportContentRepository = introductionRepository;
    }

    @GetMapping
    public BaseResponse< List<ReportContent>> getAllReportContentByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<ReportContent> breakEvenPointCustomEntity = reportContentService.getReportContent(requestNumberIf);
        return new BaseResponse<>( breakEvenPointCustomEntity,HttpStatus.OK.toString());

    }

    @PutMapping
    public BaseResponse<ReportContent> editProposedGeneralFacility(@RequestBody ReportContentDTO reportContentDTO) throws URISyntaxException {
        //reportContentDTO.set(new Date());
        ReportContent reportContent = reportContentService.updateFeasbilityRejection(reportContentDTO);
        if(reportContent!=null){
            return new BaseResponse(reportContent,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

}
