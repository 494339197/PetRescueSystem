package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.Report;
import com.petrescue.petrescuesystem.service.CommunityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community/report")
public class ReportController {

    @Autowired
    private CommunityReportService communityReportService;

    @GetMapping("/{reportId}")
    public Result<Report> getById(@PathVariable Long reportId) {
        return Result.success(communityReportService.getById(reportId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Report report) {
        return Result.success(communityReportService.save(report));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody Report report) {
        return Result.success(communityReportService.updateById(report));
    }

    @DeleteMapping("/{reportId}")
    public Result<Boolean> removeById(@PathVariable Long reportId) {
        return Result.success(communityReportService.removeById(reportId));
    }

    @GetMapping("/user/{userId}")
    public Result<List<Report>> selectByUserId(@PathVariable Long userId) {
        return Result.success(communityReportService.selectByUserId(userId));
    }

    @GetMapping("/target-type/{targetType}")
    public Result<List<Report>> selectByTargetType(@PathVariable Integer targetType) {
        return Result.success(communityReportService.selectByTargetType(targetType));
    }

    @GetMapping("/status/{status}")
    public Result<List<Report>> selectByStatus(@PathVariable Integer status) {
        return Result.success(communityReportService.selectByStatus(status));
    }

    @GetMapping("/page")
    public Result<IPage<Report>> selectReportPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(required = false) Integer targetType,
                                                  @RequestParam(required = false) Integer status) {
        Page<Report> page = new Page<>(pageNum, pageSize);
        return Result.success(communityReportService.selectReportPage(page, targetType, status));
    }

    @GetMapping("/count/user/{userId}")
    public Result<Integer> countByUserId(@PathVariable Long userId) {
        return Result.success(communityReportService.countByUserId(userId));
    }

    @GetMapping("/count/status/{status}")
    public Result<Integer> countByStatus(@PathVariable Integer status) {
        return Result.success(communityReportService.countByStatus(status));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long reportId,
                                        @RequestParam Integer status,
                                        @RequestParam(required = false) Long handlerUserId,
                                        @RequestParam(required = false) String handleNotes) {
        return Result.success(communityReportService.updateStatus(reportId, status, handlerUserId, handleNotes));
    }

    @GetMapping("/pending")
    public Result<List<Report>> selectPendingReports() {
        return Result.success(communityReportService.selectPendingReports());
    }

    @GetMapping("/recent")
    public Result<List<Report>> selectRecentReports(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(communityReportService.selectRecentReports(limit));
    }
}