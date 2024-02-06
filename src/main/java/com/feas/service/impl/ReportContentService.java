package com.feas.service.impl;

import com.feas.domain.entity.FeasbilityRejection;
import com.feas.domain.entity.Introduction;
import com.feas.domain.entity.ReportContent;
import com.feas.domain.entity.dto.FeasbilityRejectionDTO;
import com.feas.domain.entity.dto.ReportContentDTO;
import com.feas.persistence.repository.FeasbilityRejectionRepository;
import com.feas.persistence.repository.ReportContentRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ١٤/٠٢/٢٠٢٣
 */
@Service
public class ReportContentService {

    private final ReportContentRepository reportContentRepository;

    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public ReportContentService(ReportContentRepository reportContentRepository, ServiceObjectMapperImpl modelMapper) {
        this.reportContentRepository = reportContentRepository;
        this.modelMapper = modelMapper;
    }

    public List<ReportContent> getReportContent(BigDecimal requestNumberIf) {
        List<ReportContent> reportList=reportContentRepository.getAllReportContentByRequestNumber(requestNumberIf);
        return reportList;
    }

    public Optional<ReportContent> getById(Long id){
        return reportContentRepository.findById(id);
    }

    public ReportContent updateFeasbilityRejection(ReportContentDTO reportContentDTO) {
        return reportContentRepository.findById(reportContentDTO.getReportContentId())
                .map(ReportContent -> {
                    ReportContent map = modelMapper.map(reportContentDTO, ReportContent.class);
                    map.setReportContentId(reportContentDTO.getReportContentId());
                  //  map.setOperation("U");
                    reportContentRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }


}
