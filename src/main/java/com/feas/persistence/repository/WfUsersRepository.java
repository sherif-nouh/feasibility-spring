package com.feas.persistence.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.WfUsers;


@Repository
public interface WfUsersRepository extends JpaRepository<WfUsers, Long> {

    Optional<WfUsers> findByUserNo(String userNo);

}
