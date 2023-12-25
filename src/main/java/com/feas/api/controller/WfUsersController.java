package com.feas.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.feas.domain.entity.WfUsers;
import com.feas.persistence.repository.WfUsersRepository;

@RestController
@RequestMapping("/user")
public class WfUsersController {

	private final WfUsersRepository repo;



	public WfUsersController(WfUsersRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	@ResponseBody
	public Page<WfUsers> getAllUsers(
			@RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "100") int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
	  return repo.findAll( paging);
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public WfUsers getUserBy(@PathVariable("id") String id) {
	  return repo.findByUserNo(id).orElse(new WfUsers());
	}
	
}
