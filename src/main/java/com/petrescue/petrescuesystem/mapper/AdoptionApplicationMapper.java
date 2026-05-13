package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.AdoptionApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface AdoptionApplicationMapper extends BaseMapper<AdoptionApplication> {

    List<AdoptionApplication> selectByAnimalId(@Param("animalId") Long animalId);

    List<AdoptionApplication> selectByApplicantUserId(@Param("applicantUserId") Long applicantUserId);

    List<AdoptionApplication> selectByStatus(@Param("status") Integer status);

    IPage<AdoptionApplication> selectApplicationPage(
            Page<AdoptionApplication> page,
            @Param("animalId") Long animalId,
            @Param("applicantUserId") Long applicantUserId,
            @Param("status") Integer status
    );

    Integer countByAnimalId(@Param("animalId") Long animalId);

    Integer countByApplicantUserId(@Param("applicantUserId") Long applicantUserId);

    Integer updateStatus(
            @Param("applicationId") Long applicationId,
            @Param("status") Integer status,
            @Param("reviewedBy") Long reviewedBy,
            @Param("reviewNotes") String reviewNotes
    );

    List<AdoptionApplication> selectPendingApplicationsByAnimalId(@Param("animalId") Long animalId);

    List<AdoptionApplication> selectRecentApplicationsByUser(
            @Param("applicantUserId") Long applicantUserId,
            @Param("limit") Integer limit
    );
}