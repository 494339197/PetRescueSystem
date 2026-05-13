package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.RescueReport;
import com.petrescue.petrescuesystem.service.RescueReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rescue-report")
public class RescueReportController {

    @Autowired
    private RescueReportService rescueReportService;

    @GetMapping("/{reportId}")
    public Result<RescueReport> getById(@PathVariable Long reportId) {
        return Result.success(rescueReportService.getById(reportId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody RescueReport rescueReport) {
        return Result.success(rescueReportService.save(rescueReport));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody RescueReport rescueReport) {
        return Result.success(rescueReportService.updateById(rescueReport));
    }

    @DeleteMapping("/{reportId}")
    public Result<Boolean> removeById(@PathVariable Long reportId) {
        return Result.success(rescueReportService.removeById(reportId));
    }

    @GetMapping("/animal/{animalId}")
    public Result<List<RescueReport>> selectByAnimalId(@PathVariable Long animalId) {
        return Result.success(rescueReportService.selectByAnimalId(animalId));
    }

    @GetMapping("/reporter/{reporterUserId}")
    public Result<List<RescueReport>> selectByReporterUserId(@PathVariable Long reporterUserId) {
        return Result.success(rescueReportService.selectByReporterUserId(reporterUserId));
    }

    @GetMapping("/shelter/{shelterId}")
    public Result<List<RescueReport>> selectByShelterId(@PathVariable Long shelterId) {
        return Result.success(rescueReportService.selectByShelterId(shelterId));
    }

    @GetMapping("/status/{status}")
    public Result<List<RescueReport>> selectByStatus(@PathVariable Integer status) {
        return Result.success(rescueReportService.selectByStatus(status));
    }

    @GetMapping("/urgent/{urgentLevel}")
    public Result<List<RescueReport>> selectByUrgentLevel(@PathVariable Integer urgentLevel) {
        return Result.success(rescueReportService.selectByUrgentLevel(urgentLevel));
    }

    @GetMapping("/page")
    public Result<IPage<RescueReport>> selectRescueReportPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                                              @RequestParam(required = false) Long shelterId,
                                                              @RequestParam(required = false) Integer status,
                                                              @RequestParam(required = false) Integer urgentLevel) {
        Page<RescueReport> page = new Page<>(pageNum, pageSize);
        return Result.success(rescueReportService.selectRescueReportPage(page, shelterId, status, urgentLevel));
    }

    @GetMapping("/count/shelter/{shelterId}")
    public Result<Integer> countByShelterId(@PathVariable Long shelterId) {
        return Result.success(rescueReportService.countByShelterId(shelterId));
    }

    @GetMapping("/count/status/{status}")
    public Result<Integer> countByStatus(@PathVariable Integer status) {
        return Result.success(rescueReportService.countByStatus(status));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long reportId, @RequestParam Integer status, @RequestParam(required = false) Long shelterId) {
        return Result.success(rescueReportService.updateStatus(reportId, status, shelterId));
    }

    @GetMapping("/pending-urgent")
    public Result<List<RescueReport>> selectPendingUrgentReports() {
        return Result.success(rescueReportService.selectPendingUrgentReports());
    }

    @GetMapping("/recent")
    public Result<List<RescueReport>> selectRecentReports(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(rescueReportService.selectRecentReports(limit));
    }
}