package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReportMapper extends BaseMapper<Report> {

    List<Report> selectByUserId(@Param("userId") Long userId);

    List<Report> selectByTargetType(@Param("targetType") Integer targetType);

    List<Report> selectByStatus(@Param("status") Integer status);

    IPage<Report> selectReportPage(
            Page<Report> page,
            @Param("targetType") Integer targetType,
            @Param("status") Integer status
    );

    Integer countByUserId(@Param("userId") Long userId);

    Integer countByStatus(@Param("status") Integer status);

    Integer updateStatus(
            @Param("reportId") Long reportId,
            @Param("status") Integer status,
            @Param("handlerUserId") Long handlerUserId,
            @Param("handleNotes") String handleNotes
    );

    List<Report> selectPendingReports();

    List<Report> selectRecentReports(@Param("limit") Integer limit);
}