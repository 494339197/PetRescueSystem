package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Shelter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ShelterMapper extends BaseMapper<Shelter> {

    List<Shelter> selectByCity(@Param("city") String city);

    List<Shelter> selectByProvince(@Param("province") String province);

    List<Shelter> selectByStatus(@Param("status") Integer status);

    IPage<Shelter> selectShelterPage(
            Page<Shelter> page,
            @Param("province") String province,
            @Param("city") String city,
            @Param("status") Integer status
    );

    Integer countByCity(@Param("city") String city);

    Integer updateCurrentCount(@Param("shelterId") Long shelterId);

    Integer updateStatus(
            @Param("shelterId") Long shelterId,
            @Param("status") Integer status
    );

    List<Shelter> searchShelters(@Param("keyword") String keyword);

    List<Shelter> selectActiveShelters();
}