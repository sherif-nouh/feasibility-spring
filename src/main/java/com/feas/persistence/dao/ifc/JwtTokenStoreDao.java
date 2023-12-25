package com.feas.persistence.dao.ifc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.JwtTokenStore;

@Repository
public interface JwtTokenStoreDao extends JpaRepository<JwtTokenStore,String > {


}
