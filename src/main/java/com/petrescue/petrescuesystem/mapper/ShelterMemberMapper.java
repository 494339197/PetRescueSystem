package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.ShelterMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShelterMemberMapper extends BaseMapper<ShelterMember> {
    
}