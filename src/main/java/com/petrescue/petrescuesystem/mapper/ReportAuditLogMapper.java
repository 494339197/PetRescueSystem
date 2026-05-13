package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petrescue.petrescuesystem.entity.ReportAuditLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReportAuditLogMapper extends BaseMapper<ReportAuditLog> {

    List<ReportAuditLog> selectByReportId(@Param("reportId") Long reportId);

    List<ReportAuditLog> selectByOperatorUserId(@Param("operatorUserId") Long operatorUserId);

    List<ReportAuditLog> selectByAction(@Param("action") Integer action);

    Integer countByReportId(@Param("reportId") Long reportId);
}