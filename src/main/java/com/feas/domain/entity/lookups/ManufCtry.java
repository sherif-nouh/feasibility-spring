package com.feas.domain.entity.lookups;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sherif Nouh
 * @Date ٣١/٠٥/٢٠٢٣
 */
@Entity
@Table(name="MANUF_CTRY")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManufCtry implements Serializable {
    private static final long serialVersionUID = 1L;

    private String description;
    @Id
    private Long id;
}
