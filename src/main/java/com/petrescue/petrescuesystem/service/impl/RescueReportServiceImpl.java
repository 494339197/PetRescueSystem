package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.RescueReport;
import com.petrescue.petrescuesystem.mapper.RescueReportMapper;
import com.petrescue.petrescuesystem.service.RescueReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RescueReportServiceImpl implements RescueReportService {

    @Autowired
    private RescueReportMapper rescueReportMapper;

    @Override
    public RescueReport getById(Long reportId) {
        return rescueReportMapper.selectById(reportId);
    }

    @Override
    public boolean save(RescueReport rescueReport) {
        return rescueReportMapper.insert(rescueReport) > 0;
    }

    @Override
    public boolean updateById(RescueReport rescueReport) {
        return rescueReportMapper.updateById(rescueReport) > 0;
    }

    @Override
    public boolean removeById(Long reportId) {
        return rescueReportMapper.deleteById(reportId) > 0;
    }

    @Override
    public List<RescueReport> selectByAnimalId(Long animalId) {
        return rescueReportMapper.selectByAnimalId(animalId);
    }

    @Override
    public List<RescueReport> selectByReporterUserId(Long reporterUserId) {
        return rescueReportMapper.selectByReporterUserId(reporterUserId);
    }

    @Override
    public List<RescueReport> selectByShelterId(Long shelterId) {
        return rescueReportMapper.selectByShelterId(shelterId);
    }

    @Override
    public List<RescueReport> selectByStatus(Integer status) {
        return rescueReportMapper.selectByStatus(status);
    }

    @Override
    public List<RescueReport> selectByUrgentLevel(Integer urgentLevel) {
        return rescueReportMapper.selectByUrgentLevel(urgentLevel);
    }

    @Override
    public IPage<RescueReport> selectRescueReportPage(Page<RescueReport> page, Long shelterId, Integer status, Integer urgentLevel) {
        return rescueReportMapper.selectRescueReportPage(page, shelterId, status, urgentLevel);
    }

    @Override
    public Integer countByShelterId(Long shelterId) {
        return rescueReportMapper.countByShelterId(shelterId);
    }

    @Override
    public Integer countByStatus(Integer status) {
        return rescueReportMapper.countByStatus(status);
    }

    @Override
    public boolean updateStatus(Long reportId, Integer status, Long shelterId) {
        return rescueReportMapper.updateStatus(reportId, status, shelterId) > 0;
    }

    @Override
    public List<RescueReport> selectPendingUrgentReports() {
        return rescueReportMapper.selectPendingUrgentReports();
    }

    @Override
    public List<RescueReport> selectRecentReports(Integer limit) {
        return rescueReportMapper.selectRecentReports(limit);
    }
}