package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.FollowUpVisit;
import com.petrescue.petrescuesystem.mapper.FollowUpVisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/follow-up-visit")
public class FollowUpVisitController {

    @Autowired
    private FollowUpVisitMapper followUpVisitMapper;

    @GetMapping("/{visitId}")
    public Result<FollowUpVisit> getById(@PathVariable Long visitId) {
        return Result.success(followUpVisitMapper.selectById(visitId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody FollowUpVisit followUpVisit) {
        return Result.success(followUpVisitMapper.insert(followUpVisit) > 0);
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody FollowUpVisit followUpVisit) {
        return Result.success(followUpVisitMapper.updateById(followUpVisit) > 0);
    }

    @DeleteMapping("/{visitId}")
    public Result<Boolean> removeById(@PathVariable Long visitId) {
        return Result.success(followUpVisitMapper.deleteById(visitId) > 0);
    }

    @GetMapping("/contract/{contractId}")
    public Result<List<FollowUpVisit>> selectByContractId(@PathVariable Long contractId) {
        return Result.success(followUpVisitMapper.selectByContractId(contractId));
    }

    @GetMapping("/visitor/{visitorUserId}")
    public Result<List<FollowUpVisit>> selectByVisitorUserId(@PathVariable Long visitorUserId) {
        return Result.success(followUpVisitMapper.selectByVisitorUserId(visitorUserId));
    }

    @GetMapping("/page")
    public Result<IPage<FollowUpVisit>> selectFollowUpVisitPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                                @RequestParam(required = false) Long contractId,
                                                                @RequestParam(required = false) Long visitorUserId,
                                                                @RequestParam(required = false) LocalDate startDate,
                                                                @RequestParam(required = false) LocalDate endDate) {
        Page<FollowUpVisit> page = new Page<>(pageNum, pageSize);
        return Result.success(followUpVisitMapper.selectFollowUpVisitPage(page, contractId, visitorUserId, startDate, endDate));
    }

    @GetMapping("/date-range")
    public Result<List<FollowUpVisit>> selectByVisitDateRange(@RequestParam LocalDate startDate,
                                                               @RequestParam LocalDate endDate) {
        return Result.success(followUpVisitMapper.selectByVisitDateRange(startDate, endDate));
    }

    @GetMapping("/count/contract/{contractId}")
    public Result<Integer> countByContractId(@PathVariable Long contractId) {
        return Result.success(followUpVisitMapper.countByContractId(contractId));
    }

    @GetMapping("/count/visitor/{visitorUserId}")
    public Result<Integer> countByVisitorUserId(@PathVariable Long visitorUserId) {
        return Result.success(followUpVisitMapper.countByVisitorUserId(visitorUserId));
    }

    @GetMapping("/recent")
    public Result<List<FollowUpVisit>> selectRecentFollowUpVisits(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(followUpVisitMapper.selectRecentFollowUpVisits(limit));
    }

    @GetMapping("/high-satisfaction")
    public Result<List<FollowUpVisit>> selectHighSatisfactionVisits(@RequestParam(defaultValue = "4") Integer minSatisfaction) {
        return Result.success(followUpVisitMapper.selectHighSatisfactionVisits(minSatisfaction));
    }

    @PutMapping("/photos")
    public Result<Boolean> updatePhotos(@RequestParam Long visitId, @RequestParam String photos) {
        return Result.success(followUpVisitMapper.updatePhotos(visitId, photos) > 0);
    }

    @PutMapping("/satisfaction")
    public Result<Boolean> updateSatisfaction(@RequestParam Long visitId,
                                              @RequestParam Integer satisfaction,
                                              @RequestParam(required = false) String notes) {
        return Result.success(followUpVisitMapper.updateSatisfaction(visitId, satisfaction, notes) > 0);
    }
}