package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.RescueReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface RescueReportMapper extends BaseMapper<RescueReport> {

    List<RescueReport> selectByAnimalId(@Param("animalId") Long animalId);

    List<RescueReport> selectByReporterUserId(@Param("reporterUserId") Long reporterUserId);

    List<RescueReport> selectByShelterId(@Param("shelterId") Long shelterId);

    List<RescueReport> selectByStatus(@Param("status") Integer status);

    List<RescueReport> selectByUrgentLevel(@Param("urgentLevel") Integer urgentLevel);

    IPage<RescueReport> selectRescueReportPage(
            Page<RescueReport> page,
            @Param("shelterId") Long shelterId,
            @Param("status") Integer status,
            @Param("urgentLevel") Integer urgentLevel
    );

    Integer countByShelterId(@Param("shelterId") Long shelterId);

    Integer countByStatus(@Param("status") Integer status);

    Integer updateStatus(
            @Param("reportId") Long reportId,
            @Param("status") Integer status,
            @Param("shelterId") Long shelterId
    );

    List<RescueReport> selectPendingUrgentReports();

    List<RescueReport> selectRecentReports(@Param("limit") Integer limit);
}