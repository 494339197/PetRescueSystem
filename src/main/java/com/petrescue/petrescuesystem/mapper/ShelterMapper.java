package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.Shelter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShelterMapper extends BaseMapper<Shelter> {
    
}