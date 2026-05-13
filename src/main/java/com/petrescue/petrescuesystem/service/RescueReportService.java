package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.RescueReport;
import java.util.List;

public interface RescueReportService {

    RescueReport getById(Long reportId);

    boolean save(RescueReport rescueReport);

    boolean updateById(RescueReport rescueReport);

    boolean removeById(Long reportId);

    List<RescueReport> selectByAnimalId(Long animalId);

    List<RescueReport> selectByReporterUserId(Long reporterUserId);

    List<RescueReport> selectByShelterId(Long shelterId);

    List<RescueReport> selectByStatus(Integer status);

    List<RescueReport> selectByUrgentLevel(Integer urgentLevel);

    IPage<RescueReport> selectRescueReportPage(Page<RescueReport> page, Long shelterId, Integer status, Integer urgentLevel);

    Integer countByShelterId(Long shelterId);

    Integer countByStatus(Integer status);

    boolean updateStatus(Long reportId, Integer status, Long shelterId);

    List<RescueReport> selectPendingUrgentReports();

    List<RescueReport> selectRecentReports(Integer limit);
}