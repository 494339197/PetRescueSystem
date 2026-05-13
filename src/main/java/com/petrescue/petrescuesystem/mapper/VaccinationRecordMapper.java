package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.VaccinationRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface VaccinationRecordMapper extends BaseMapper<VaccinationRecord> {

    List<VaccinationRecord> selectByAnimalId(@Param("animalId") Long animalId);

    List<VaccinationRecord> selectByVaccineType(@Param("vaccineType") String vaccineType);

    IPage<VaccinationRecord> selectVaccinationPage(
            Page<VaccinationRecord> page,
            @Param("animalId") Long animalId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<VaccinationRecord> selectByDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    List<VaccinationRecord> selectDueVaccinations();

    List<VaccinationRecord> selectRecentByAnimalId(
            @Param("animalId") Long animalId,
            @Param("limit") Integer limit
    );

    Integer countByAnimalId(@Param("animalId") Long animalId);

    Integer countByVaccineType(@Param("vaccineType") String vaccineType);
}