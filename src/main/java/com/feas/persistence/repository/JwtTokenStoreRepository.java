package com.feas.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feas.domain.entity.JwtTokenStore;

public interface JwtTokenStoreRepository extends JpaRepository<JwtTokenStore, String> {

}
