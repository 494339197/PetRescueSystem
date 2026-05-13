package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.Report;
import com.petrescue.petrescuesystem.mapper.ReportMapper;
import com.petrescue.petrescuesystem.service.CommunityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommunityReportServiceImpl implements CommunityReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public Report getById(Long reportId) {
        return reportMapper.selectById(reportId);
    }

    @Override
    public boolean save(Report report) {
        return reportMapper.insert(report) > 0;
    }

    @Override
    public boolean updateById(Report report) {
        return reportMapper.updateById(report) > 0;
    }

    @Override
    public boolean removeById(Long reportId) {
        return reportMapper.deleteById(reportId) > 0;
    }

    @Override
    public List<Report> selectByUserId(Long userId) {
        return reportMapper.selectByUserId(userId);
    }

    @Override
    public List<Report> selectByTargetType(Integer targetType) {
        return reportMapper.selectByTargetType(targetType);
    }

    @Override
    public List<Report> selectByStatus(Integer status) {
        return reportMapper.selectByStatus(status);
    }

    @Override
    public IPage<Report> selectReportPage(Page<Report> page, Integer targetType, Integer status) {
        return reportMapper.selectReportPage(page, targetType, status);
    }

    @Override
    public Integer countByUserId(Long userId) {
        return reportMapper.countByUserId(userId);
    }

    @Override
    public Integer countByStatus(Integer status) {
        return reportMapper.countByStatus(status);
    }

    @Override
    public boolean updateStatus(Long reportId, Integer status, Long handlerUserId, String handleNotes) {
        return reportMapper.updateStatus(reportId, status, handlerUserId, handleNotes) > 0;
    }

    @Override
    public List<Report> selectPendingReports() {
        return reportMapper.selectPendingReports();
    }

    @Override
    public List<Report> selectRecentReports(Integer limit) {
        return reportMapper.selectRecentReports(limit);
    }
}