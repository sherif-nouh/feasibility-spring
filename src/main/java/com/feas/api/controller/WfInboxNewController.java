package com.feas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.feas.domain.entity.WfInboxNew;
import com.feas.persistence.repository.WfInboxNewRepository;

@RestController
@RequestMapping("/wf-inbox-new")
public class WfInboxNewController {
	
	@Autowired
	private WfInboxNewRepository wfInboxRepo;
	
	@GetMapping
	@ResponseBody
	public Page<WfInboxNew> getAllInboxRequest(
			@RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "25") int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
	  return wfInboxRepo.findAll(paging);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public WfInboxNew getAllInboxByRequest(@PathVariable(name = "id") final Long id) {
		return  wfInboxRepo.findById(id).orElse(null);
	}

}
