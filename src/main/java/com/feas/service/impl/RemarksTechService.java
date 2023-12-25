package com.feas.service.impl;

import com.feas.domain.entity.RawMaterialStorage;
import com.feas.domain.entity.dto.RawMaterialStorageDTO;
import com.feas.domain.entity.dto.RemarksTechDTO;
import com.feas.domain.entity.lookups.RemarksTech;
import com.feas.persistence.repository.lookup.RemarksTechRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٦/٢٠٢٣
 */
@Service
public class RemarksTechService {
    private final RemarksTechRepository remarksTechRepository;
    private final ServiceObjectMapperImpl modelMapper;

    public RemarksTechService(RemarksTechRepository remarksTechRepository, ServiceObjectMapperImpl modelMapper) {
        this.remarksTechRepository = remarksTechRepository;
        this.modelMapper = modelMapper;
    }

    public RemarksTech getRemarksTech(Long licenseNumberIf,Long requestNumberIf){
        List<RemarksTech> lst= remarksTechRepository.findByLicenseNumberIfAndRequestNumberIf(licenseNumberIf,requestNumberIf);
    if(lst.isEmpty()){
        RemarksTech rt= new RemarksTech();
        rt.setLicenseNumberIf(new BigDecimal(licenseNumberIf));
        rt.setProjectNumberIf(new BigDecimal(licenseNumberIf));
        rt.setRequestNumberIf(new BigDecimal(requestNumberIf));
        return new RemarksTech();
    }
    return lst.get(0);
    }

    public RemarksTech addRemarksTech(RemarksTechDTO remarksTech) {
        RemarksTech map = modelMapper.map(remarksTech, RemarksTech.class);
        map.setInsertDt(new Date());
        return remarksTechRepository.save(map);
    }

    public RemarksTech deleteRemarksTech(RemarksTech remarksTech) {
         remarksTech.setOperation("D");
        remarksTech.setUpdateDt(new Date());
        return remarksTechRepository.save(remarksTech);
    }
}
