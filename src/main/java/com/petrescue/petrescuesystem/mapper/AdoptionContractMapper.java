package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.AdoptionContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface AdoptionContractMapper extends BaseMapper<AdoptionContract> {

    AdoptionContract selectByApplicationId(@Param("applicationId") Long applicationId);

    AdoptionContract selectByContractNo(@Param("contractNo") String contractNo);

    IPage<AdoptionContract> selectContractPage(
            Page<AdoptionContract> page,
            @Param("contractNo") String contractNo,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<AdoptionContract> selectBySignDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<AdoptionContract> selectTrialEndingContracts(@Param("days") Integer days);

    List<AdoptionContract> selectExpiredTrialContracts();

    Integer updateFileUrl(
            @Param("contractId") Long contractId,
            @Param("fileUrl") String fileUrl
    );

    Integer updateAdopterSignUrl(
            @Param("contractId") Long contractId,
            @Param("adopterSignUrl") String adopterSignUrl
    );

    Integer updateShelterSignUrl(
            @Param("contractId") Long contractId,
            @Param("shelterSignUrl") String shelterSignUrl
    );

    Integer countBySignDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<AdoptionContract> selectRecentContracts(@Param("limit") Integer limit);
}