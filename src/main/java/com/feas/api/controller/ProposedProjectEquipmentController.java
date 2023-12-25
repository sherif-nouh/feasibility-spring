package com.feas.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.TechnicalStudySummary;
import com.feas.service.impl.ProposedProjectEquipmentService;
import com.feas.service.impl.TechnicalStudySummaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.feas.domain.entity.ProposedProjectEquipment;
import com.feas.persistence.repository.ProposedProjectEquipmentRepository;
import com.feas.service.model.BaseResponse;

@RestController
@RequestMapping("/proposed-project-equipment")
@Tag(name = "proposed-project-equipment", description = "N_PROPOSED_PROJECT_EQUIPMENT -   معدات المشروع")
public class ProposedProjectEquipmentController {
	
	@Autowired
	private ProposedProjectEquipmentService projectEquipmentService;
	@Autowired
	private TechnicalStudySummaryService technicalStudySummaryService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public BaseResponse<List<ProposedProjectEquipment>> getAllByLicAndReq(
            @RequestParam(defaultValue = "-1") Long requestNumberIf,
            @RequestParam(defaultValue = "-1") Long licenseNumberIf) {
        List<ProposedProjectEquipment> queryAll = projectEquipmentService.QueryAll(licenseNumberIf,requestNumberIf);

       return new BaseResponse<List<ProposedProjectEquipment>>(queryAll,HttpStatus.OK.toString()); 
	
	}
	@GetMapping("/{id}")
	@ResponseBody
	public BaseResponse<ProposedProjectEquipment> getOneById( @PathVariable Long id) throws Exception {
		Optional<ProposedProjectEquipment> projectEquipment= projectEquipmentService.findById(id);
		return new BaseResponse<ProposedProjectEquipment>(projectEquipment.orElseThrow(() -> new Exception(" not found - " + id)),HttpStatus.OK.toString());
	}



	@PostMapping
	public BaseResponse<ProposedProjectEquipment> createProposedProjectEquip(@RequestBody ProposedProjectEquipment proposedProjectEquipment) throws URISyntaxException {
		proposedProjectEquipment.setDateStamp(new Date());
		ProposedProjectEquipment savedProposedProject = projectEquipmentService.save(proposedProjectEquipment);
		if(savedProposedProject!=null){
			return new BaseResponse(savedProposedProject,HttpStatus.OK.toString());
		}else{
			return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
		}
	}



	@PutMapping
	public BaseResponse<ProposedProjectEquipment> updateProposedProjectEquip( @RequestBody ProposedProjectEquipment proposedProjectEquipment) {

		if(proposedProjectEquipment!=null && "D".equalsIgnoreCase(proposedProjectEquipment.getOperation()) ){
			proposedProjectEquipment.setOperation("D");
		}else{
			proposedProjectEquipment.setOperation("U");
		}
		proposedProjectEquipment.setDateStamp(new Date());
		ProposedProjectEquipment prop = projectEquipmentService.save(proposedProjectEquipment);
		/*prop = projectEquipmentService.save(proposedProjectEquipment);*/
		if(prop!=null){
			return new BaseResponse(prop,HttpStatus.OK.toString());
		}else{
			return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
		}
	}

	@PostMapping("/save-technical-study")
	public BaseResponse<TechnicalStudySummary> saveProposedProjectEquip( @RequestBody ProposedProjectEquipment proposedProjectEquipment) {
		TechnicalStudySummary technicalStudySummary = technicalStudySummaryService.saveTechnicalStudySummaryFromProposedProject(proposedProjectEquipment);
		return new BaseResponse<TechnicalStudySummary>(technicalStudySummary,HttpStatus.OK.toString());
	}


}
