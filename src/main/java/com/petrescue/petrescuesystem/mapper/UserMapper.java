package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    
}