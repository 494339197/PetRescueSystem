package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.ShelterMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ShelterMemberMapper extends BaseMapper<ShelterMember> {

    List<ShelterMember> selectByShelterId(@Param("shelterId") Long shelterId);

    List<ShelterMember> selectByUserId(@Param("userId") Long userId);

    List<ShelterMember> selectByRole(@Param("role") Integer role);

    ShelterMember selectByShelterAndUser(
            @Param("shelterId") Long shelterId,
            @Param("userId") Long userId
    );

    Integer countByShelterId(@Param("shelterId") Long shelterId);

    Integer countByRole(@Param("role") Integer role);

    Integer updateRole(
            @Param("id") Long id,
            @Param("role") Integer role
    );

    Integer updateStatus(
            @Param("id") Long id,
            @Param("status") Integer status
    );

    List<ShelterMember> selectByShelterIdAndRole(
            @Param("shelterId") Long shelterId,
            @Param("role") Integer role
    );
}