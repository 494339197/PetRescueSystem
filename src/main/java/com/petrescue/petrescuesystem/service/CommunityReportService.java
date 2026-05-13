package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Report;
import java.util.List;

public interface CommunityReportService {

    Report getById(Long reportId);

    boolean save(Report report);

    boolean updateById(Report report);

    boolean removeById(Long reportId);

    List<Report> selectByUserId(Long userId);

    List<Report> selectByTargetType(Integer targetType);

    List<Report> selectByStatus(Integer status);

    IPage<Report> selectReportPage(Page<Report> page, Integer targetType, Integer status);

    Integer countByUserId(Long userId);

    Integer countByStatus(Integer status);

    boolean updateStatus(Long reportId, Integer status, Long handlerUserId, String handleNotes);

    List<Report> selectPendingReports();

    List<Report> selectRecentReports(Integer limit);
}