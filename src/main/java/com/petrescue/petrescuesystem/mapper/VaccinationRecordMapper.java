package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.VaccinationRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VaccinationRecordMapper extends BaseMapper<VaccinationRecord> {
    
}