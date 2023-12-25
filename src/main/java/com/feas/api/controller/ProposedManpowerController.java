package com.feas.api.controller;

import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.dto.ProposedManpowerDTO;
import com.feas.domain.entity.dto.SummaryLabour;
import com.feas.service.impl.ProposedManpowerService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("/proposed-manpower")
@Tag(name = "proposed-manpower", description = "N_PROPOSED_MANPOWER -   العمالة اللازمة للإنتاج")
public class ProposedManpowerController {

    private final ProposedManpowerService proposedManpowerService;

    public ProposedManpowerController(ProposedManpowerService proposedManpowerService) {
        this.proposedManpowerService = proposedManpowerService;
    }

    @GetMapping
    public BaseResponse<List<ProposedManpower>> getAllManPowerByRequestNumber( @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<ProposedManpower> allManPowerByRequestNumber = proposedManpowerService.getAllManPowerByRequestNumber(requestNumberIf);
        return new BaseResponse<>(allManPowerByRequestNumber, HttpStatus.OK.toString());
    }
    @GetMapping("/page")
    public BaseResponse<Page<ProposedManpower>> getAllManPowerByRequestNumberAsPage(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<ProposedManpower> allManPowerByRequestNumber = proposedManpowerService.getAllManPowerByRequestNumberAsPage(requestNumberIf,pageable);
        return new BaseResponse<>(allManPowerByRequestNumber, HttpStatus.OK.toString());
    }

    @GetMapping("/summary-labour")
    public BaseResponse<SummaryLabour> getSummaryLabour(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        SummaryLabour summaryLabour = proposedManpowerService.getSummaryLabour(requestNumberIf);
        return new BaseResponse(summaryLabour,HttpStatus.OK.toString());
    }

    @GetMapping("/dept-remarks")
    public BaseResponse<String> getDeptRemarks(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        String deptRemarks = proposedManpowerService.getDeptRemarks(requestNumberIf);
        return new BaseResponse(deptRemarks,HttpStatus.OK.toString());
    }

    @PostMapping
    public BaseResponse<ProposedManpower> addProposedManpower(@RequestBody ProposedManpowerDTO proposedManpowerDTO) throws URISyntaxException {
        proposedManpowerDTO.setOperation("I");
        proposedManpowerDTO.setDateStamp(new Date());
        ProposedManpower proposedManpower = proposedManpowerService.addProposedManpower(proposedManpowerDTO);
        if(proposedManpower!=null){
            return new BaseResponse(proposedManpower,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }


    }

    @PutMapping
    public BaseResponse<ProposedManpower> editProposedManpower(@RequestBody ProposedManpowerDTO proposedManpowerDTO) throws URISyntaxException {
        if(proposedManpowerDTO!=null && "D".equalsIgnoreCase(proposedManpowerDTO.getOperation()) ){
            proposedManpowerDTO.setOperation("D");
        }else{
            proposedManpowerDTO.setOperation("U");
        }
        proposedManpowerDTO.setDateStamp(new Date());
        ProposedManpower proposedManpower = proposedManpowerService.updateProposedManpower(proposedManpowerDTO);
        if(proposedManpower!=null){
            return new BaseResponse(proposedManpower,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

   /* @PutMapping("/delete")
    public ResponseEntity<Void> deleteProposedManpower(@RequestBody ProposedManpowerDTO  proposedManpowerDTO) throws URISyntaxException {
      //  String proposedManpower = proposedManpowerService.deleteProposedManpower(proposedManpowerId);
        proposedManpowerDTO.setOperation("D");
        proposedManpowerDTO.setDateStamp(new Date());
        ProposedManpower  proposedManpower1=proposedManpowerService.updateProposedManpower(proposedManpowerDTO);

        if(proposedManpower1!=null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
*/
}
