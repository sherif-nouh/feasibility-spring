package com.feas.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FeasibilityPendingVwKey implements Serializable {
   // private long requestNo;
  //  private String licenseNo;
    private long requestNumberId;

}
